import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VotingSystemFinal extends JFrame implements ActionListener {
    private JFrame currentFrame;
    private JTextField userField, idField, regIdField, regNameField, regAgeField;
    private JPasswordField passField;
    private JButton loginBtn, verifyBtn, regBtn, logoutBtn, backBtn;
    
    // Design Palette
    private final Color pastelBlue = new Color(173, 216, 230);
    private final Color pastelGreen = new Color(204, 255, 229);
    private final Color pastelRed = new Color(255, 182, 193);
    private final Color pastelGold = new Color(255, 250, 205);
    private final Font boldFont = new Font("Verdana", Font.BOLD, 14);

    // Database Configuration
    private final String dbUrl = "jdbc:mysql://localhost:3306/voting_db"; 
    private final String dbUser = "root"; 
    private final String dbPass = "root"; // Update with your MySQL password
    private String currentVoterID = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VotingSystemFinal().createLeadLogin());
    }

    private void styleBtn(JButton b, Color bg) {
        b.setPreferredSize(new Dimension(220, 45));
        b.setBackground(bg);
        b.setForeground(Color.BLACK);
        b.setFont(boldFont);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    // 1. LOGIN GATEWAY
    public void createLeadLogin() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("Secure Gateway Login");
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
        currentFrame.setVisible(true);
        currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 2. VOTER REGISTRATION (Super Admin)
    public void createRegistrationWindow() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("Voter Registration Portal");
        currentFrame.setSize(500, 500);
        currentFrame.setLayout(new GridBagLayout());
        currentFrame.setLocationRelativeTo(null);

        regIdField = new JTextField(15);
        regNameField = new JTextField(15);
        regAgeField = new JTextField(15);
        regBtn = new JButton("Register Voter");
        backBtn = new JButton("Back to Login");
        styleBtn(regBtn, pastelGreen);
        styleBtn(backBtn, Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0; currentFrame.add(new JLabel("Voter ID:"), gbc);
        gbc.gridx = 1; currentFrame.add(regIdField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; currentFrame.add(new JLabel("Full Name:"), gbc);
        gbc.gridx = 1; currentFrame.add(regNameField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; currentFrame.add(new JLabel("Age (18-119):"), gbc);
        gbc.gridx = 1; currentFrame.add(regAgeField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; currentFrame.add(regBtn, gbc);
        gbc.gridy = 4; currentFrame.add(backBtn, gbc);

        regBtn.addActionListener(this);
        backBtn.addActionListener(e -> createLeadLogin());
        currentFrame.setVisible(true);
    }

    // 3. VERIFIER PORTAL
    public void createVerifyWindow() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("ID Verification Dashboard");
        currentFrame.setSize(450, 400);
        currentFrame.setLayout(new GridBagLayout());
        currentFrame.setLocationRelativeTo(null);

        idField = new JTextField(15);
        verifyBtn = new JButton("Verify Member");
        logoutBtn = new JButton("Logout Lead");
        styleBtn(verifyBtn, pastelBlue);
        styleBtn(logoutBtn, pastelRed);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridy = 0; currentFrame.add(new JLabel("Enter Voter ID:"), gbc);
        gbc.gridy = 1; currentFrame.add(idField, gbc);
        gbc.gridy = 2; currentFrame.add(verifyBtn, gbc);
        gbc.gridy = 3; currentFrame.add(logoutBtn, gbc);

        verifyBtn.addActionListener(this);
        logoutBtn.addActionListener(e -> createLeadLogin());
        currentFrame.setVisible(true);
    }

    // 4. VOTING INTERFACE (With Symbols)
    public void createVotingScreen() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("Official Ballot");
        currentFrame.setSize(950, 600);
        currentFrame.setLayout(new GridLayout(1, 3, 20, 0));
        ((JPanel)currentFrame.getContentPane()).setBorder(new EmptyBorder(40,40,40,40));
        currentFrame.setLocationRelativeTo(null);

        String[][] parties = {
            {"Party A", "FAN", "🌀"}, 
            {"Party B", "CYCLE", "🚲"}, 
            {"Party C", "HELICOPTER", "🚁"}
        };

        for (String[] p : parties) {
            JPanel card = new JPanel(new BorderLayout(10, 10));
            card.setBorder(BorderFactory.createTitledBorder(p[0]));
            JLabel sym = new JLabel(p[2], JLabel.CENTER);
            sym.setFont(new Font("Serif", Font.PLAIN, 120));
            JButton btn = new JButton("Vote for " + p[1]);
            styleBtn(btn, Color.WHITE);
            btn.addActionListener(e -> handleVote(p[0]));
            card.add(sym, BorderLayout.CENTER);
            card.add(btn, BorderLayout.SOUTH);
            currentFrame.add(card);
        }
        currentFrame.setVisible(true);
    }

    // 5. CHIEF RESULTS DASHBOARD
    public void createChiefDashboard() {
        if (currentFrame != null) currentFrame.dispose();
        currentFrame = new JFrame("Chief Authority - Results");
        currentFrame.setSize(600, 500);
        currentFrame.setLayout(new BorderLayout());
        currentFrame.setLocationRelativeTo(null);

        JPanel resPanel = new JPanel();
        resPanel.setLayout(new BoxLayout(resPanel, BoxLayout.Y_AXIS));
        resPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        String winner = "None";
        int maxVotes = -1;

        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            ResultSet rs = con.prepareStatement("SELECT * FROM party").executeQuery();
            while (rs.next()) {
                String name = rs.getString("party_name");
                int votes = rs.getInt("vote_count");
                JLabel lbl = new JLabel(name + " : " + votes + " Votes");
                lbl.setFont(new Font("Verdana", Font.BOLD, 18));
                resPanel.add(lbl);
                resPanel.add(Box.createRigidArea(new Dimension(0, 15)));
                if (votes > maxVotes) { maxVotes = votes; winner = name; }
            }
        } catch (Exception e) { resPanel.add(new JLabel("DB Connection Error")); }

        JLabel winLabel = new JLabel("WINNER: " + winner.toUpperCase(), JLabel.CENTER);
        winLabel.setFont(new Font("Verdana", Font.BOLD, 22));
        winLabel.setBackground(pastelGold);
        winLabel.setOpaque(true);
        winLabel.setPreferredSize(new Dimension(600, 70));

        JButton logout = new JButton("Logout Chief");
        styleBtn(logout, pastelRed);
        logout.addActionListener(e -> createLeadLogin());

        currentFrame.add(winLabel, BorderLayout.NORTH);
        currentFrame.add(new JScrollPane(resPanel), BorderLayout.CENTER);
        currentFrame.add(logout, BorderLayout.SOUTH);
        currentFrame.setVisible(true);
    }

    private void handleVote(String partyName) {
        int confirm = JOptionPane.showConfirmDialog(null, "Submit vote for " + partyName + "?");
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                con.setAutoCommit(false);
                PreparedStatement ps1 = con.prepareStatement("UPDATE voter SET has_voted='Y' WHERE member_id=?");
                ps1.setString(1, currentVoterID); ps1.executeUpdate();
                PreparedStatement ps2 = con.prepareStatement("UPDATE party SET vote_count=vote_count+1 WHERE party_name=?");
                ps2.setString(1, partyName); ps2.executeUpdate();
                con.commit();
                JOptionPane.showMessageDialog(null, "Vote cast successfully!");
                createVerifyWindow();
            } catch (Exception ex) { JOptionPane.showMessageDialog(null, "Vote Error: " + ex.getMessage()); }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String u = userField.getText(), p = new String(passField.getPassword());
            if (u.equals("super") && p.equals("0000")) createRegistrationWindow();
            else if (u.equals("admin") && p.equals("1234")) createVerifyWindow();
            else if (u.equals("chief") && p.equals("9999")) createChiefDashboard();
            else JOptionPane.showMessageDialog(null, "Access Denied");
        }

        if (e.getSource() == regBtn) {
            try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO voter (member_id, member_name, age, has_voted) VALUES (?, ?, ?, 'N')");
                ps.setString(1, regIdField.getText().trim());
                ps.setString(2, regNameField.getText().trim());
                ps.setInt(3, Integer.parseInt(regAgeField.getText().trim()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registered Successfully!");
            } catch (Exception ex) { JOptionPane.showMessageDialog(null, "Error: Check ID/Age format."); }
        }

        if (e.getSource() == verifyBtn) {
            try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                PreparedStatement ps = con.prepareStatement("SELECT has_voted FROM voter WHERE member_id=?");
                ps.setString(1, idField.getText().trim());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    if ("Y".equals(rs.getString("has_voted"))) JOptionPane.showMessageDialog(null, "Already Voted");
                    else { currentVoterID = idField.getText().trim(); createVotingScreen(); }
                } else { JOptionPane.showMessageDialog(null, "ID Not Found"); }
            } catch (Exception ex) { JOptionPane.showMessageDialog(null, "DB Error"); }
        }
    }
}