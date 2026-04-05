import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FinalVotingSystemPro extends JFrame implements ActionListener {
    private JFrame currentFrame;
    private JTextField userField, idField, regIdField, regNameField, regAgeField, voterIdField;
    private JPasswordField passField, voterPassField;
    private JButton loginBtn, verifyBtn, regBtn, logoutBtn, backBtn, cancelVoteBtn, voterLoginBtn;
    
    // Design Palette
    private final Color pastelBlue = new Color(173, 216, 230);
    private final Color pastelGreen = new Color(204, 255, 229);
    private final Color pastelRed = new Color(255, 182, 193);
    private final Color pastelGold = new Color(255, 250, 205);
    private final Font boldFont = new Font("Verdana", Font.BOLD, 14);

    // Database Details
    private final String dbUrl = "jdbc:mysql://localhost:3306/voting_db"; 
    private final String dbUser = "root"; 
    private final String dbPass = "root";
    private String currentVoterID = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch(Exception e){}
            new FinalVotingSystemPro().createLeadLogin();
        });
    }

    // Standardized Button Styling
    private void styleBtn(JButton b, Color bg) {
        b.setPreferredSize(new Dimension(220, 45));
        b.setBackground(bg);
        b.setForeground(Color.BLACK);
        b.setFont(boldFont);
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    // 1. LEAD LOGIN WINDOW
    public void createLeadLogin() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("Lead Login Gateway");
        currentFrame.setSize(450, 400);
        currentFrame.setLayout(new GridBagLayout());
        currentFrame.setLocationRelativeTo(null);

        userField = new JTextField(15);
        passField = new JPasswordField(15);
        loginBtn = new JButton("Login");
        styleBtn(loginBtn, pastelBlue);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; currentFrame.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1; currentFrame.add(userField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; currentFrame.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; currentFrame.add(passField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; currentFrame.add(loginBtn, gbc);

        loginBtn.addActionListener(this);
       JButton resultsBtn = new JButton(" View Results");
        styleBtn(resultsBtn, pastelGold);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        currentFrame.add(resultsBtn, gbc);
        resultsBtn.addActionListener(e -> createResultsWindow());

        currentFrame.setVisible(true);
        currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 2. VOTER REGISTRATION (Super Admin: super / 0000) - FIXED
    public void createRegistrationWindow() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame(" New Voter Registration");
        currentFrame.setSize(550, 600);
        currentFrame.setLayout(new GridBagLayout());
        currentFrame.setLocationRelativeTo(null);

        regIdField = new JTextField(15);
        regNameField = new JTextField(15);
        regAgeField = new JTextField(15);
        regBtn = new JButton(" Register Voter");
        backBtn = new JButton(" Back to Login");
        
        styleBtn(regBtn, pastelGreen);
        styleBtn(backBtn, Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0; currentFrame.add(new JLabel("Voter ID:"), gbc);
        gbc.gridx = 1; currentFrame.add(regIdField, gbc);
        
        // AUTO ID BUTTON
        JButton autoIdBtn = new JButton("Auto ID");
        autoIdBtn.setPreferredSize(new Dimension(120, 35));
        autoIdBtn.setBackground(Color.blue);
        autoIdBtn.setForeground(Color.BLACK);
        autoIdBtn.setFont(boldFont);
        autoIdBtn.addActionListener(e -> generateNextVoterId());
        gbc.gridx = 2; gbc.gridy = 0; currentFrame.add(autoIdBtn, gbc);

        gbc.gridx = 0; gbc.gridy = 1; currentFrame.add(new JLabel("Full Name:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; currentFrame.add(regNameField, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 2; currentFrame.add(new JLabel("Age (18-119):"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; currentFrame.add(regAgeField, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 3; currentFrame.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; 
        JPasswordField regPassField = new JPasswordField(15);
        currentFrame.add(regPassField, gbc);
        
        gbc.gridy = 4; gbc.gridwidth = 3; currentFrame.add(regBtn, gbc);
        gbc.gridy = 5; currentFrame.add(backBtn, gbc);

        regBtn.addActionListener(this);
        backBtn.addActionListener(e -> createLeadLogin());
        currentFrame.setVisible(true);
    }

    // AUTO GENERATE NEXT VOTER ID
    private void generateNextVoterId() {
        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT MAX(CAST(SUBSTRING(member_id,2) AS UNSIGNED)) + 1 as next_id FROM voter WHERE member_id LIKE 'V%'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int nextId = rs.getInt("next_id");
                regIdField.setText("V" + String.format("%03d", nextId > 0 ? nextId : 114));
            } else {
                regIdField.setText("V114");
            }
        } catch (Exception ex) {
            regIdField.setText("V114");
        }
        regIdField.setCaretPosition(regIdField.getText().length());
    }

    // 3. MEMBER IDENTITY VERIFICATION (Lead Person: admin / 1234)
    public void createVerifyWindow() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("🔍 Identity Verification Portal");
        currentFrame.setSize(450, 400);
        currentFrame.setLayout(new GridBagLayout());
        currentFrame.setLocationRelativeTo(null);

        idField = new JTextField(15);
        idField.setFont(new Font("Arial", Font.BOLD, 18));
        verifyBtn = new JButton(" Verify Member");
        logoutBtn = new JButton(" Logout Lead");
        
        styleBtn(verifyBtn, pastelBlue);
        styleBtn(logoutBtn, pastelRed);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridy = 0; currentFrame.add(new JLabel("Enter Member ID:"), gbc);
        gbc.gridy = 1; currentFrame.add(idField, gbc);
        gbc.gridy = 2; currentFrame.add(verifyBtn, gbc);
        gbc.gridy = 3; currentFrame.add(logoutBtn, gbc);

        verifyBtn.addActionListener(this);
        logoutBtn.addActionListener(e -> createLeadLogin());
        currentFrame.setVisible(true);
    }

    // 3.5 VOTER LOGIN WINDOW
    public void createVoterWindow() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("🗳️ Voter Login Portal");
        currentFrame.setSize(500, 450);
        currentFrame.setLayout(new GridBagLayout());
        currentFrame.setLocationRelativeTo(null);

        voterIdField = new JTextField(15);
        voterPassField = new JPasswordField(15);
        voterLoginBtn = new JButton("🔑 Login & Vote");
        JButton backToVerifyBtn = new JButton("← Back to Verification");

        styleBtn(voterLoginBtn, pastelBlue);
        styleBtn(backToVerifyBtn, Color.WHITE);

        JLabel title = new JLabel("Enter Your Voter Credentials", JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        currentFrame.add(title, gbc);
        
        gbc.gridwidth = 1; gbc.gridy = 1;
        gbc.gridx = 0; currentFrame.add(new JLabel("Voter ID:"), gbc);
        gbc.gridx = 1; currentFrame.add(voterIdField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; currentFrame.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; currentFrame.add(voterPassField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; 
        currentFrame.add(voterLoginBtn, gbc);
        gbc.gridy = 4; gbc.gridwidth = 1;
        currentFrame.add(backToVerifyBtn, gbc);

        voterLoginBtn.addActionListener(this);
        backToVerifyBtn.addActionListener(e -> createVerifyWindow());
        currentFrame.setVisible(true);
        currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 4. VOTING SCREEN
    public void createVotingScreen() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("🗳️ Main Voting Interface");
        currentFrame.setSize(900, 600);
        currentFrame.setLayout(new BorderLayout());
        currentFrame.setLocationRelativeTo(null);

        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        centerPanel.setBorder(new EmptyBorder(40, 40, 40, 40));

        String[][] parties = {{"Party A", "🦁"}, {"Party B", "🐘"}, {"Party C", "🦅"}};
        for (String[] party : parties) {
            JPanel card = new JPanel(new BorderLayout(10, 10));
            card.setBorder(BorderFactory.createTitledBorder(party[0]));
            JLabel sym = new JLabel(party[1], JLabel.CENTER);
            sym.setFont(new Font("Serif", Font.PLAIN, 100));
            JButton b = new JButton(" Cast Vote");
            styleBtn(b, Color.WHITE);
            b.addActionListener(e -> handleVote(party[0]));
            card.add(sym, BorderLayout.CENTER);
            card.add(b, BorderLayout.SOUTH);
            centerPanel.add(card);
        }

        cancelVoteBtn = new JButton("❌ Cancel & Back");
        styleBtn(cancelVoteBtn, pastelRed);
        cancelVoteBtn.addActionListener(e -> createVerifyWindow());
        currentFrame.add(centerPanel, BorderLayout.CENTER);
        currentFrame.add(cancelVoteBtn, BorderLayout.SOUTH);
        currentFrame.setVisible(true);
    }
    // 5. RESULTS DASHBOARD (Admin Only)
    // ✅ PERFECT RESULTS PANEL - NO CAST ERRORS
public void createResultsWindow() {
    if (currentFrame != null) currentFrame.dispose();
    currentFrame = new JFrame("📊 Election Results Dashboard");
    currentFrame.setSize(800, 600);
    currentFrame.setLayout(new BorderLayout());
    currentFrame.setLocationRelativeTo(null);

    JPanel mainPanel = new JPanel(new BorderLayout());
    
    try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
        // SIMPLE SAFE QUERY - NO CAST FUNCTIONS
        PreparedStatement ps = con.prepareStatement(
            "SELECT party_name, COALESCE(vote_count, 0) as votes FROM party ORDER BY votes DESC");
        ResultSet rs = ps.executeQuery();
        
        // Collect data SAFELY
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Party");
        model.addColumn("Symbol");
        model.addColumn("Votes");
        model.addColumn("Percentage");
        
        int totalVotes = 0;
        String winner = "No votes yet";
        
        // Read results
        while (rs.next()) {
            String party = rs.getString("party_name");
            int votes = rs.getInt("votes");
            totalVotes += votes;
            
            if (votes > 0) winner = party;
            
            String symbol = getPartySymbol(party);
            model.addRow(new Object[]{party, symbol, votes, "0%"});
        }
        
        // Update percentages SAFELY
        if (totalVotes > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                int votes = (Integer) model.getValueAt(i, 2);
                double percent = (double) votes / totalVotes * 100;
                model.setValueAt(String.format("%.1f%%", percent), i, 3);
            }
        }
        
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(50);
        table.setGridColor(Color.BLUE);
        table.getTableHeader().setFont(boldFont);
        table.getTableHeader().setBackground(pastelBlue);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel winnerLabel = new JLabel(" WINNER: " + winner, JLabel.CENTER);
        winnerLabel.setFont(new Font("Verdana", Font.BOLD, 28));
        winnerLabel.setForeground(Color.RED);
        
        JLabel totalLabel = new JLabel(" Total Votes: " + totalVotes, JLabel.CENTER);
        totalLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        totalLabel.setForeground(Color.BLUE);
        
        headerPanel.add(winnerLabel, BorderLayout.NORTH);
        headerPanel.add(totalLabel, BorderLayout.CENTER);
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton refreshBtn = new JButton(" Refresh");
        JButton backBtn = new JButton(" Back");
        styleBtn(refreshBtn, pastelGreen);
        styleBtn(backBtn, pastelBlue);
        
        refreshBtn.addActionListener(e -> createResultsWindow());
        backBtn.addActionListener(e -> createLeadLogin());
        
        buttonPanel.add(refreshBtn);
        buttonPanel.add(backBtn);
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
    } catch (Exception ex) {
        JLabel errorLabel = new JLabel("❌ Error loading results: " + ex.getMessage(), JLabel.CENTER);
        errorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        errorLabel.setForeground(Color.RED);
        mainPanel.add(errorLabel, BorderLayout.CENTER);
    }
    
    currentFrame.add(mainPanel);
    currentFrame.setVisible(true);
    currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

private String getPartySymbol(String partyName) {
    if (partyName.equals("Party A")) return "🦁";
    if (partyName.equals("Party B")) return "🐘";
    if (partyName.equals("Party C")) return "🦅";
    return "❓";
}


// Helper method for party symbols
private String getPartySymbol(String partyName) {
    switch(partyName) {
        case "Party A": return "🦁";
        case "Party B": return "🐘";
        case "Party C": return "🦅";
        default: return "❓";
    }
}


    private void handleVote(String partyName) {
        int confirm = JOptionPane.showConfirmDialog(null, 
            "✅ Confirm your vote for " + partyName + "?\n\nThis cannot be changed!", 
            "Final Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                con.setAutoCommit(false);
                PreparedStatement p1 = con.prepareStatement("UPDATE voter SET has_voted='Y' WHERE member_id=?");
                p1.setString(1, currentVoterID); p1.executeUpdate();
                PreparedStatement p2 = con.prepareStatement("UPDATE party SET vote_count=vote_count+1 WHERE party_name=?");
                p2.setString(1, partyName); p2.executeUpdate();
                con.commit();
                JOptionPane.showMessageDialog(null, "🎉 Vote cast successfully!\nThank you for voting!", 
                    "Vote Recorded", JOptionPane.INFORMATION_MESSAGE);
                createVerifyWindow();
            } catch (Exception ex) { 
                JOptionPane.showMessageDialog(null, "❌ Vote Error: " + ex.getMessage()); 
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String u = userField.getText(), p = new String(passField.getPassword());
            if (u.equals("super") && p.equals("0000")) createRegistrationWindow();
            else if (u.equals("admin") && p.equals("1234")) createVerifyWindow();
            else JOptionPane.showMessageDialog(null, "❌ Access Denied!");
        }

        // ✅ FIXED REGISTRATION - MATCHES YOUR DATABASE (member_name)
        if (e.getSource() == regBtn) {
            String id = regIdField.getText().trim();
            String name = regNameField.getText().trim();
            String ageInput = regAgeField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || ageInput.isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ All fields required!");
                return;
            }
            
            // ✅ DUPLICATE CHECK FIRST
            try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                PreparedStatement check = con.prepareStatement("SELECT COUNT(*) FROM voter WHERE member_id=?");
                check.setString(1, id);
                ResultSet rs = check.executeQuery();
                rs.next();
                
                if (rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, 
                        "❌ ID '" + id + "' ALREADY EXISTS!\n✅ Click '🆕 Auto ID' or use V114, V115...", 
                        "Duplicate ID", JOptionPane.WARNING_MESSAGE);
                    regIdField.setText("V114");
                    regIdField.requestFocus();
                    return;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "❌ DB Check Failed!");
                return;
            }
            
            // ✅ INSERT USING YOUR EXACT COLUMNS: member_id, member_name, age, has_voted
            try {
                int age = Integer.parseInt(ageInput);
                if (age >= 18 && age < 120) {
                    try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                        PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO voter (member_id, member_name, age, has_voted) VALUES (?, ?, ?, 'N')");
                        ps.setString(1, id);
                        ps.setString(2, name);  // member_name (YOUR column name)
                        ps.setInt(3, age);
                        ps.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, 
                            "✅ '" + name + "' (ID: " + id + ") REGISTERED SUCCESSFULLY!\n⏩ Admin can now verify.",
                            "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        createLeadLogin();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "❌ Age must be 18-119");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "❌ Age must be a number!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "❌ Registration failed: " + ex.getMessage());
            }
        }

        // ✅ FIXED VERIFY BUTTON - Uses member_name
        if (e.getSource() == verifyBtn) {
            String id = idField.getText().trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ Please enter Member ID!");
                return;
            }
            
            try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                // YOUR TABLE STRUCTURE: member_id, has_voted, member_name, age
                PreparedStatement ps = con.prepareStatement("SELECT has_voted, member_name FROM voter WHERE member_id=?");
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    if ("Y".equals(rs.getString("has_voted"))) {
                        JOptionPane.showMessageDialog(null, "❌ " + rs.getString("member_name") + " has already voted!");
                    } else {
                        currentVoterID = id;
                        JOptionPane.showMessageDialog(null, "✅ " + rs.getString("member_name") + " verified!\n⏩ Opening Voter Login...");
                        createVoterWindow();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "❌ No voter found with ID: " + id);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "❌ Database Connection Failed!");
            }
        }

        // VOTER LOGIN BUTTON
        if (e.getSource() == voterLoginBtn) {
            String voterId = voterIdField.getText().trim();
            String voterPassword = new String(voterPassField.getPassword());
            
            if (voterId.isEmpty() || voterPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ Enter both Voter ID and Password!");
                return;
            }
            verifyVoterLogin(voterId, voterPassword);
        }
    }

    // VOTER LOGIN VERIFICATION - FIXED
    private void verifyVoterLogin(String voterId, String password) {
        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT member_name FROM voter WHERE member_id=? AND has_voted='N'");
            ps.setString(1, voterId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() && voterId.equals(currentVoterID)) {
                currentVoterID = voterId;
                JOptionPane.showMessageDialog(null, 
                    "✅ Welcome " + rs.getString("member_name") + "!\nYou are verified to vote.",
                    "Access Granted", JOptionPane.INFORMATION_MESSAGE);
                createVotingScreen();
            } else {
                JOptionPane.showMessageDialog(null, 
                    "❌ Invalid ID or already voted!\nAdmin must verify first.",
                    "Access Denied", JOptionPane.ERROR_MESSAGE);
                voterIdField.setText(""); voterPassField.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "❌ Database Error: " + ex.getMessage());
        }
    }
}
