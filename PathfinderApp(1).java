import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Pathfinder - Career & Education Advisor
 * A beginner-friendly Java Swing desktop prototype.
 * Save as PathfinderApp.java and run with: javac PathfinderApp.java && java PathfinderApp
 */
public class PathfinderApp extends JFrame {
    private static final Color NAVY = new Color(24, 55, 79);
    private static final Color GREEN = new Color(45, 119, 94);
    private static final Color PALE = new Color(239, 247, 242);
    private static final Color BG = new Color(247, 249, 248);
    private static final Color MUTED = new Color(100, 115, 110);

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel pages = new JPanel(cardLayout);
    private final JTextField nameField = new JTextField(18);
    private final JComboBox<String> courseBox = new JComboBox<>(new String[]{
            "B.Tech Computer Science", "B.Tech Information Technology", "B.Tech Electronics",
            "B.Sc Computer Science", "B.Com", "Other"});
    private final JComboBox<String> yearBox = new JComboBox<>(new String[]{
            "1st Year", "2nd Year", "3rd Year", "4th Year", "Graduate"});
    private final JTextField marksField = new JTextField(18);
    private final JComboBox<String> goalBox = new JComboBox<>(new String[]{
            "Explore my options", "Software Engineer", "Data Analyst", "Cybersecurity Analyst",
            "UI/UX Designer", "Product Manager"});
    private final JTextField skillsField = new JTextField(18);
    private final JCheckBox coding = new JCheckBox("Coding", true);
    private final JCheckBox problemSolving = new JCheckBox("Problem solving");
    private final JCheckBox design = new JCheckBox("Design");
    private final JCheckBox data = new JCheckBox("Data & analytics");
    private final JCheckBox helping = new JCheckBox("Helping people");
    private final JCheckBox business = new JCheckBox("Business");
    private final JCheckBox research = new JCheckBox("Research");
    private final List<JCheckBox> milestones = new ArrayList<>();
    private final JLabel statusLabel = new JLabel("Welcome! Start by completing your profile.");
    private final JTextArea careerResults = new JTextArea();
    private final JComboBox<String> assessment1 = new JComboBox<>(new String[]{"Writing code to solve a problem", "Finding patterns in data", "Investigating how something works", "Designing an easy-to-use screen"});
    private final JComboBox<String> assessment2 = new JComboBox<>(new String[]{"Logical puzzles", "Comparing information", "Finding and fixing weaknesses", "Making things clear and attractive"});
    private final JComboBox<String> assessment3 = new JComboBox<>(new String[]{"Structured problem solving", "Attention to detail", "Curiosity and investigation", "Creativity and empathy"});
    private final JComboBox<String> assessment4 = new JComboBox<>(new String[]{"A useful app", "A report with insights", "A safer digital system", "A friendly user experience"});
    private final JComboBox<String> assessment5 = new JComboBox<>(new String[]{"Build and test solutions", "Explore evidence and trends", "Investigate and troubleshoot", "Understand people and improve designs"});

    public PathfinderApp() {
        setTitle("Pathfinder | Career & Education Advisor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 720);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout());
        add(buildSidebar(), BorderLayout.WEST);
        add(buildMainArea(), BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        statusLabel.setBorder(new EmptyBorder(8, 15, 10, 15));
        statusLabel.setForeground(MUTED);
        refreshCareerResults();
    }

    private JPanel buildSidebar() {
        JPanel side = new JPanel();
        side.setPreferredSize(new Dimension(215, 0));
        side.setBackground(Color.WHITE);
        side.setBorder(new EmptyBorder(22, 14, 18, 14));
        side.setLayout(new BoxLayout(side, BoxLayout.Y_AXIS));

        JLabel brand = new JLabel("  ◈  pathfinder");
        brand.setFont(new Font("SansSerif", Font.BOLD, 22));
        brand.setForeground(NAVY);
        side.add(brand);
        JLabel subtitle = new JLabel("     CAREER & EDUCATION");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 10));
        subtitle.setForeground(MUTED);
        side.add(subtitle);
        side.add(Box.createVerticalStrut(30));

        addNavButton(side, "Dashboard", "dashboard");
        addNavButton(side, "Student Profile", "profile");
        addNavButton(side, "Career Assessment", "assessment");
        addNavButton(side, "Career Matches", "careers");
        addNavButton(side, "Skill Gap Analysis", "skills");
        addNavButton(side, "Courses & Education", "education");
        addNavButton(side, "Learning Roadmap", "roadmap");
        side.add(Box.createVerticalGlue());
        JLabel quote = new JLabel("<html><b>Your future, in focus</b><br><br>Small steps today can open up<br>new opportunities tomorrow.</html>");
        quote.setOpaque(true);
        quote.setBackground(PALE);
        quote.setForeground(NAVY);
        quote.setBorder(new EmptyBorder(14, 12, 14, 12));
        side.add(quote);
        return side;
    }

    private void addNavButton(JPanel side, String text, String page) {
        JButton button = new JButton(text);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        button.setFocusPainted(false);
        button.setBackground(Color.WHITE);
        button.setForeground(NAVY);
        button.setBorder(new EmptyBorder(10, 12, 10, 8));
        button.addActionListener(e -> showPage(page));
        side.add(button);
        side.add(Box.createVerticalStrut(4));
    }

    private JPanel buildMainArea() {
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(BG);
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(Color.WHITE);
        top.setBorder(new EmptyBorder(18, 25, 18, 25));
        JLabel title = new JLabel("Your personal career compass");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setForeground(NAVY);
        top.add(title, BorderLayout.WEST);
        JLabel user = new JLabel("STUDENT  ");
        user.setForeground(GREEN);
        user.setFont(new Font("SansSerif", Font.BOLD, 12));
        top.add(user, BorderLayout.EAST);
        main.add(top, BorderLayout.NORTH);

        pages.setBackground(BG);
        pages.setBorder(new EmptyBorder(22, 25, 22, 25));
        pages.add(buildDashboard(), "dashboard");
        pages.add(buildProfile(), "profile");
        pages.add(buildAssessment(), "assessment");
        pages.add(buildCareers(), "careers");
        pages.add(buildSkills(), "skills");
        pages.add(buildEducation(), "education");
        pages.add(buildRoadmap(), "roadmap");
        main.add(pages, BorderLayout.CENTER);
        return main;
    }

    private JPanel pagePanel(String heading, String description) {
        JPanel panel = new JPanel();
        panel.setBackground(BG);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel h = new JLabel(heading);
        h.setFont(new Font("SansSerif", Font.BOLD, 26));
        h.setForeground(NAVY);
        h.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(h);
        JLabel d = new JLabel("<html>" + description + "</html>");
        d.setFont(new Font("SansSerif", Font.PLAIN, 13));
        d.setForeground(MUTED);
        d.setBorder(new EmptyBorder(7, 0, 18, 0));
        d.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(d);
        return panel;
    }

    private JPanel whiteCard() {
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 235, 229)), new EmptyBorder(18, 18, 18, 18)));
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setAlignmentX(Component.LEFT_ALIGNMENT);
        return p;
    }

    private JPanel buildDashboard() {
        JPanel p = pagePanel("Welcome to Pathfinder!", "Turn your interests into your next opportunity.");
        JPanel hero = whiteCard();
        JLabel heroTitle = new JLabel("Discover a direction. Build a plan.");
        heroTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        heroTitle.setForeground(GREEN);
        hero.add(heroTitle);
        hero.add(Box.createVerticalStrut(8));
        hero.add(new JLabel("Explore career ideas, identify skills to develop, and plan your next steps."));
        hero.add(Box.createVerticalStrut(15));
        JButton profile = primaryButton("Complete student profile");
        profile.addActionListener(e -> showPage("profile"));
        hero.add(profile);
        p.add(hero);
        p.add(Box.createVerticalStrut(16));
        JPanel links = new JPanel(new GridLayout(2, 2, 12, 12));
        links.setOpaque(false);
        links.add(dashboardTile("Career assessment", "Answer five quick questions", "assessment"));
        links.add(dashboardTile("Career matches", "Compare possible career paths", "careers"));
        links.add(dashboardTile("Skill gap analysis", "See skills to practise", "skills"));
        links.add(dashboardTile("Learning roadmap", "Track your milestones", "roadmap"));
        p.add(links);
        return p;
    }

    private JPanel dashboardTile(String title, String text, String page) {
        JPanel tile = whiteCard();
        JLabel h = new JLabel(title);
        h.setFont(new Font("SansSerif", Font.BOLD, 15));
        h.setForeground(NAVY);
        tile.add(h);
        tile.add(Box.createVerticalStrut(7));
        tile.add(new JLabel(text));
        tile.add(Box.createVerticalStrut(10));
        JButton b = new JButton("Open →");
        b.addActionListener(e -> showPage(page));
        tile.add(b);
        return tile;
    }

    private JPanel buildProfile() {
        JPanel p = pagePanel("Student Profile", "Tell us about your background so suggestions can be more relevant.");
        JPanel card = whiteCard();
        addFormRow(card, "Full name", nameField);
        addFormRow(card, "Current course", courseBox);
        addFormRow(card, "Study year", yearBox);
        addFormRow(card, "Current marks / CGPA", marksField);
        addFormRow(card, "Career goal", goalBox);
        addFormRow(card, "Skills you already have", skillsField);
        JLabel interestsLabel = new JLabel("Interests");
        interestsLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        card.add(interestsLabel);
        JPanel interests = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 3));
        interests.setOpaque(false);
        for (JCheckBox cb : new JCheckBox[]{coding, problemSolving, design, data, helping, business, research}) interests.add(cb);
        card.add(interests);
        card.add(Box.createVerticalStrut(12));
        JButton save = primaryButton("Save profile");
        save.addActionListener(e -> {
            if (nameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name first.", "Profile", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            statusLabel.setText("Profile saved for " + nameField.getText().trim() + ". (This demo keeps data in memory only.)");
            JOptionPane.showMessageDialog(this, "Profile saved for this session.");
        });
        card.add(save);
        p.add(card);
        return p;
    }

    private void addFormRow(JPanel parent, String label, JComponent input) {
        JPanel row = new JPanel(new BorderLayout(12, 4));
        row.setOpaque(false);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        JLabel l = new JLabel(label);
        l.setPreferredSize(new Dimension(170, 28));
        l.setForeground(NAVY);
        row.add(l, BorderLayout.WEST);
        row.add(input, BorderLayout.CENTER);
        parent.add(row);
        parent.add(Box.createVerticalStrut(8));
    }

    private JPanel buildAssessment() {
        JPanel p = pagePanel("Career Assessment", "Choose the answer that feels closest to you. This is a reflection activity, not a validated test.");
        JPanel card = whiteCard();
        addQuestion(card, "1. Which activity sounds most interesting?", assessment1);
        addQuestion(card, "2. What kind of task do you enjoy?", assessment2);
        addQuestion(card, "3. Which strength sounds most like you?", assessment3);
        addQuestion(card, "4. What would you most like to create?", assessment4);
        addQuestion(card, "5. How do you prefer to work?", assessment5);
        JButton submit = primaryButton("Show my career matches");
        submit.addActionListener(e -> {
            refreshCareerResults();
            statusLabel.setText("Assessment reviewed. Explore the career matches as starting points.");
            showPage("careers");
        });
        card.add(Box.createVerticalStrut(8));
        card.add(submit);
        p.add(card);
        return p;
    }

    private void addQuestion(JPanel card, String question, JComboBox<String> choices) {
        JLabel q = new JLabel(question);
        q.setFont(new Font("SansSerif", Font.BOLD, 12));
        q.setForeground(NAVY);
        card.add(q);
        card.add(Box.createVerticalStrut(5));
        choices.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        choices.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(choices);
        card.add(Box.createVerticalStrut(12));
    }

    private JPanel buildCareers() {
        JPanel p = pagePanel("Career Matches", "These are illustrative suggestions. Research real job roles before making decisions.");
        careerResults.setEditable(false);
        careerResults.setFont(new Font("Monospaced", Font.PLAIN, 13));
        careerResults.setBackground(Color.WHITE);
        careerResults.setForeground(NAVY);
        careerResults.setBorder(new EmptyBorder(14, 14, 14, 14));
        JPanel card = whiteCard();
        card.add(careerResults);
        JButton refresh = primaryButton("Refresh suggestions");
        refresh.addActionListener(e -> refreshCareerResults());
        card.add(Box.createVerticalStrut(10));
        card.add(refresh);
        p.add(card);
        return p;
    }

    private void refreshCareerResults() {
        StringBuilder result = new StringBuilder();
        result.append("POTENTIAL CAREER DIRECTIONS\n\n");
        result.append("1. Software Engineer\n   Build applications and software systems.\n   Skills: Java, problem solving, databases, Git.\n\n");
        result.append("2. Data Analyst\n   Turn data into useful insights.\n   Skills: SQL, spreadsheets, statistics, visualisation.\n\n");
        result.append("3. Cybersecurity Analyst\n   Help protect systems and information.\n   Skills: networking, Linux, security fundamentals.\n\n");
        result.append("4. UI/UX Designer\n   Design clear and useful digital experiences.\n   Skills: user research, wireframes, Figma, testing.\n\n");
        result.append("5. Product Manager\n   Connect user needs, business goals and teams.\n   Skills: communication, prioritisation, planning.\n\n");
        result.append("Note: these are learning prompts, not scientifically calculated match scores.");
        careerResults.setText(result.toString());
        careerResults.setCaretPosition(0);
    }

    private JPanel buildSkills() {
        JPanel p = pagePanel("Skill Gap Analysis", "Choose a direction and use the checklist to plan what to learn next.");
        JPanel card = whiteCard();
        JComboBox<String> career = new JComboBox<>(new String[]{"Software Engineer", "Data Analyst", "Cybersecurity Analyst", "UI/UX Designer", "Product Manager"});
        JTextArea output = new JTextArea(10, 40);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setBackground(PALE);
        JButton show = primaryButton("Show skills");
        show.addActionListener(e -> {
            String selected = (String) career.getSelectedItem();
            output.setText(skillsFor(selected));
        });
        card.add(new JLabel("Career direction"));
        card.add(career);
        card.add(show);
        card.add(Box.createVerticalStrut(12));
        card.add(new JScrollPane(output));
        output.setText(skillsFor("Software Engineer"));
        p.add(card);
        return p;
    }

    private String skillsFor(String career) {
        if ("Data Analyst".equals(career)) return "DATA ANALYST SKILLS\n☐ SQL queries\n☐ Spreadsheets\n☐ Data visualisation\n☐ Basic statistics\n☐ Explaining insights clearly";
        if ("Cybersecurity Analyst".equals(career)) return "CYBERSECURITY SKILLS\n☐ Networking fundamentals\n☐ Linux basics\n☐ Security principles\n☐ Log analysis\n☐ Ethical and responsible practice";
        if ("UI/UX Designer".equals(career)) return "UI/UX DESIGN SKILLS\n☐ User research\n☐ Wireframing\n☐ Figma prototyping\n☐ Usability testing\n☐ Visual communication";
        if ("Product Manager".equals(career)) return "PRODUCT MANAGEMENT SKILLS\n☐ User discovery\n☐ Prioritisation\n☐ Communication\n☐ Basic analytics\n☐ Project planning";
        return "SOFTWARE ENGINEERING SKILLS\n☐ Java or another programming language\n☐ Data structures and algorithms\n☐ SQL and database design\n☐ Git and collaboration\n☐ Testing and debugging";
    }

    private JPanel buildEducation() {
        JPanel p = pagePanel("Courses & Education", "Start with reputable learning resources and verify details on official websites.");
        JPanel card = whiteCard();
        addResource(card, "Java programming", "Learn syntax, object-oriented programming and application development.", "https://dev.java/learn/");
        addResource(card, "SQL and databases", "Practise queries, joins and database design.", "https://dev.mysql.com/doc/");
        addResource(card, "Data analysis", "Build skills in data handling, visualisation and insights.", "https://www.kaggle.com/learn");
        addResource(card, "UI/UX design", "Explore user research, wireframes and prototyping.", "https://www.figma.com/resource-library/");
        addResource(card, "Cybersecurity basics", "Learn networking and security fundamentals responsibly.", "https://skillsforall.com/");
        addResource(card, "Compare colleges", "Check eligibility, curriculum, fees and placement reports.", "https://www.nirfindia.org/");
        p.add(card);
        return p;
    }

    private void addResource(JPanel card, String title, String description, String url) {
        JLabel heading = new JLabel(title + "  —  " + description);
        heading.setForeground(NAVY);
        card.add(heading);
        JButton open = new JButton("Open resource: " + url);
        open.setAlignmentX(Component.LEFT_ALIGNMENT);
        open.addActionListener(e -> {
            try {
                if (Desktop.isDesktopSupported()) Desktop.getDesktop().browse(java.net.URI.create(url));
                else JOptionPane.showMessageDialog(this, url);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Open this link in your browser:\n" + url);
            }
        });
        card.add(open);
        card.add(Box.createVerticalStrut(10));
    }

    private JPanel buildRoadmap() {
        JPanel p = pagePanel("Learning Roadmap", "Tick off milestones as you make progress. This demo tracks progress while the app is open.");
        JPanel card = whiteCard();
        String[][] steps = {
                {"Set your direction", "Complete your profile and reflect on your interests."},
                {"Explore career paths", "Review recommendations and research real job roles."},
                {"Build core skills", "Practise programming, communication and problem-solving."},
                {"Create a portfolio project", "Build a small project and document what you learned."},
                {"Prepare for opportunities", "Improve your CV, seek feedback and explore internships."}
        };
        for (String[] step : steps) {
            JCheckBox check = new JCheckBox(step[0] + " — " + step[1]);
            check.setOpaque(false);
            check.setForeground(NAVY);
            check.setFont(new Font("SansSerif", Font.PLAIN, 12));
            milestones.add(check);
            card.add(check);
            card.add(Box.createVerticalStrut(10));
        }
        JButton progress = primaryButton("Update progress");
        progress.addActionListener(e -> {
            int count = 0;
            for (JCheckBox check : milestones) if (check.isSelected()) count++;
            statusLabel.setText("Roadmap progress: " + count + " of " + milestones.size() + " milestones completed (" + (count * 100 / milestones.size()) + "%).");
        });
        JButton reset = new JButton("Reset checklist");
        reset.addActionListener(e -> {
            for (JCheckBox check : milestones) check.setSelected(false);
            statusLabel.setText("Roadmap checklist reset.");
        });
        card.add(progress);
        card.add(reset);
        p.add(card);
        return p;
    }

    private JButton primaryButton(String text) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setBackground(GREEN);
        b.setForeground(Color.WHITE);
        b.setBorder(new EmptyBorder(10, 15, 10, 15));
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
        return b;
    }

    private void showPage(String page) {
        cardLayout.show(pages, page);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PathfinderApp().setVisible(true));
    }
}
