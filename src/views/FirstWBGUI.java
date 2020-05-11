package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.border.SoftBevelBorder;

import common.Club;
import common.ClubLineConverter;
import common.FileHelper;
import common.Member;
import common.MemberLineConverter;
import common.MultiClubMember;
import common.SingleClubMember;

import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FirstWBGUI extends JFrame {
	
	
	
	

	private JPanel contentPane;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLayeredPane layeredPane;
	private JPanel homePanel;
	private JPanel addMemberPanel;
	private JPanel memberCheckInPanel;
	private JPanel generateMemberBillPanel;
	private JPanel removeMemberAccPanel;
	private JLabel homePanelTitleLbl;
	private JLabel addMemberTitleLbl;
	private JLabel memberCheckInTitleLbl;
	private JLabel memberBillTitleLbl;
	private JLabel removeMemberTitleLbl;
	private JPanel displayMemberInfoPanel;
	private JLabel displayMemberInfoTitleLbl;
	private JLabel addMemberNamelbl;
	private JTextField memberNameTxtField;
	private JLabel memberTypeLbl;
	private JRadioButton rbAddMemTypeSingle;
	private JRadioButton rbAddMemTypeMulti;
	private JLabel memberBirthdayLbl;
	private JTextField memberBirthdayTxtField;
	private JButton addMemberSubmitBtn;
	public static Scanner scnr = new Scanner(System.in);
	private static int idNum = 100;
    
	private JTextField memberNameTxtField_CI;
	private JLabel memberNameLbl_CI;
	private JButton checkInBtn;
	private JLabel memberNameLbl_GMB;
	private JTextField memberNametxtField_GMB;
	private JButton generateBillBtn;
	private JLabel memberNameLbl_RMA;
	private JLabel memberNameLbl_DMI;
	private JTextField memberNametxtField_RMA;
	private JTextField memberNametxtField_DMI;
	private JButton removeMemberBtn;
	private JButton displayMemberBtn;
	private static List<Member> memberList = new ArrayList<>();
	private static List<Club> clubList = new ArrayList<>();
	private String inputMemberName;
	String inputBirthday;
	private JComboBox addMemberCb;
	String input;
	
	
	
	
	
	
	
	static {
		clubList.add(new Club("Detroit", "1570 Woodward Ave floor 3, Detroit, MI 48226"));
		clubList.add(new Club("Grand Rapids", "40 Pearl St NW #200, Grand Rapids, MI 49503"));
		clubList.add(new Club("Royal Oak", "1455 Main St., Royal Oak, MI"));
		clubList.add(new Club("West Bloomfeild", "2324 Main St., West Bloomfield, MI"));

	}
	
	private static FileHelper<Member> helper = new FileHelper<>("membersgui.txt", new MemberLineConverter(clubList));
	private static FileHelper<Club> clubHelper = new FileHelper<>("clubgui.txt", new ClubLineConverter());
	private JComboBox memberCheckIncb;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_5;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWBGUI frame = new FirstWBGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstWBGUI() {
		memberList = helper.readAll();// Refills this list with current values from file
		clubHelper.rewrite(clubList); // this prints the current club list to a file
		
		initComponents();
		createEvents();
		
	}
//////////////////////////////////////////////////////
//This method contains all the code for creating and
//initializing components.
//////////////////////////////////////////////////////

public void initComponents() {
	setTitle("Fitness Center Member Manager");
	setIconImage(Toolkit.getDefaultToolkit().getImage(FirstWBGUI.class.getResource("/resources/dumbellIcon_64.png")));
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnNewMenu = new JMenu("File");
	menuBar.add(mnNewMenu);
	
	mntmNewMenuItem_6 = new JMenuItem("Home");
	
	mntmNewMenuItem_6.setIcon(new ImageIcon(FirstWBGUI.class.getResource("/resources/homeicon_16.png")));
	mnNewMenu.add(mntmNewMenuItem_6);
	
	mntmNewMenuItem = new JMenuItem("Add New Member");
	
	mntmNewMenuItem.setIcon(new ImageIcon(FirstWBGUI.class.getResource("/resources/plussignicon_16.png")));
	mnNewMenu.add(mntmNewMenuItem);
	
	mntmNewMenuItem_1 = new JMenuItem("Member Check In");
	
	mntmNewMenuItem_1.setIcon(new ImageIcon(FirstWBGUI.class.getResource("/resources/checkMark_16.png")));
	mnNewMenu.add(mntmNewMenuItem_1);
	
	mntmNewMenuItem_3 = new JMenuItem("Remove Member Account");
	mntmNewMenuItem_3.setIcon(new ImageIcon(FirstWBGUI.class.getResource("/resources/MinusMark_16.png")));
	mnNewMenu.add(mntmNewMenuItem_3);
	
	mntmNewMenuItem_2 = new JMenuItem("Generate Member Bill");
	mntmNewMenuItem_2.setIcon(new ImageIcon(FirstWBGUI.class.getResource("/resources/Dollarsign_16.png")));
	mnNewMenu.add(mntmNewMenuItem_2);
	
	mntmNewMenuItem_4 = new JMenuItem("Display Member Information");
	mntmNewMenuItem_4.setIcon(new ImageIcon(FirstWBGUI.class.getResource("/resources/infosign_16.png")));
	mnNewMenu.add(mntmNewMenuItem_4);
	
	mntmNewMenuItem_7 = new JMenuItem("Exit");
	mntmNewMenuItem_7.setIcon(new ImageIcon(FirstWBGUI.class.getResource("/resources/exiticon_16.png")));
	
	mnNewMenu.add(mntmNewMenuItem_7);
	
	JMenu helpMenu = new JMenu("Help");
	menuBar.add(helpMenu);
	
	mntmNewMenuItem_5 = new JMenuItem("About");
	
	mntmNewMenuItem_5.setIcon(new ImageIcon(FirstWBGUI.class.getResource("/resources/abouticon_16.png")));
	helpMenu.add(mntmNewMenuItem_5);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	layeredPane = new JLayeredPane();
	layeredPane.setBounds(10, 11, 414, 217);
	contentPane.add(layeredPane);
	layeredPane.setLayout(new CardLayout(0, 0));
	
	homePanel = new JPanel();
	layeredPane.add(homePanel, "name_1438237637637400");
	
	homePanelTitleLbl = new JLabel("WELCOME TO THE MEMBER MANAGER");
	homePanel.add(homePanelTitleLbl);
	
	addMemberPanel = new JPanel();
	layeredPane.add(addMemberPanel, "name_1438273308145800");
	
	addMemberNamelbl = new JLabel("Member First Name:");
	
	addMemberTitleLbl = new JLabel("NEW MEMBER REGISTRATION");
	addMemberTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
	
	memberNameTxtField = new JTextField();
	memberNameTxtField.setColumns(10);
	
	memberTypeLbl = new JLabel("Member Type:");
	
	rbAddMemTypeSingle = new JRadioButton("SINGLE");
	
	rbAddMemTypeSingle.setSelected(true);
	buttonGroup.add(rbAddMemTypeSingle);
	
	rbAddMemTypeMulti = new JRadioButton("MULTI");
	
	buttonGroup.add(rbAddMemTypeMulti);
	
	memberBirthdayLbl = new JLabel("Member Birthday:");
	
	memberBirthdayTxtField = new JTextField();
	memberBirthdayTxtField.setColumns(10);
	
	addMemberSubmitBtn = new JButton("SUBMIT");
	
	addMemberCb = new JComboBox<>();
	addMemberCb.setModel(new DefaultComboBoxModel(new String[] {"Detroit", "Grand Rapids", "Royal Oak", "West Bloomfield"}));
//	addMemberCb.setModel(new DefaultComboBoxModel(new String[] {"Detroit", "Grand Rapids", "Royal Oak ", "West Bloomfield"}));
//	addMemberCb.addItem(new Club("Detroit", "1570 Woodward Ave floor 3, Detroit, MI 48226"));
//	addMemberCb.addItem(new Club("Grand Rapids", "40 Pearl St NW #200, Grand Rapids, MI 49503"));
//	addMemberCb.addItem(new Club("Royal Oak", "1455 Main St., Royal Oak, MI"));
//	addMemberCb.addItem(new Club("West Bloomfeild", "2324 Main St., West Bloomfield, MI"));
	
	GroupLayout gl_addMemberPanel = new GroupLayout(addMemberPanel);
	gl_addMemberPanel.setHorizontalGroup(
		gl_addMemberPanel.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_addMemberPanel.createSequentialGroup()
				.addGroup(gl_addMemberPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_addMemberPanel.createSequentialGroup()
						.addGap(125)
						.addComponent(addMemberTitleLbl))
					.addGroup(gl_addMemberPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_addMemberPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(memberBirthdayLbl)
							.addComponent(addMemberNamelbl)
							.addComponent(memberTypeLbl))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_addMemberPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_addMemberPanel.createSequentialGroup()
								.addComponent(rbAddMemTypeSingle)
								.addGap(14)
								.addComponent(rbAddMemTypeMulti))
							.addComponent(memberNameTxtField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addComponent(memberBirthdayTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(addMemberCb, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(133, Short.MAX_VALUE))
			.addGroup(gl_addMemberPanel.createSequentialGroup()
				.addContainerGap(335, Short.MAX_VALUE)
				.addComponent(addMemberSubmitBtn)
				.addContainerGap())
	);
	gl_addMemberPanel.setVerticalGroup(
		gl_addMemberPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_addMemberPanel.createSequentialGroup()
				.addGap(6)
				.addComponent(addMemberTitleLbl)
				.addGap(8)
				.addGroup(gl_addMemberPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(memberTypeLbl)
					.addComponent(rbAddMemTypeMulti)
					.addComponent(rbAddMemTypeSingle))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_addMemberPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(addMemberNamelbl)
					.addComponent(memberNameTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_addMemberPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(memberBirthdayLbl)
					.addComponent(memberBirthdayTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(addMemberCb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
				.addComponent(addMemberSubmitBtn)
				.addContainerGap())
	);
	addMemberPanel.setLayout(gl_addMemberPanel);
	
	memberCheckInPanel = new JPanel();
	layeredPane.add(memberCheckInPanel, "name_1438276876462400");
	
	memberCheckInTitleLbl = new JLabel("MEMBER CHECKIN");
	
	memberNameTxtField_CI = new JTextField();
	memberNameTxtField_CI.setText("");
	memberNameTxtField_CI.setColumns(10);
	
	memberNameLbl_CI = new JLabel("Member First Name:");
	
	checkInBtn = new JButton("Check In");
	
	
	memberCheckIncb = new JComboBox();
	memberCheckIncb.setModel(new DefaultComboBoxModel(new String[] {"Detroit ", "Grand Rapids", "Royal Oak", "West Bloomfield"}));
	
	JLabel clubNameLbl_MCI = new JLabel("Club: ");
	GroupLayout gl_memberCheckInPanel = new GroupLayout(memberCheckInPanel);
	gl_memberCheckInPanel.setHorizontalGroup(
		gl_memberCheckInPanel.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_memberCheckInPanel.createSequentialGroup()
				.addGap(163)
				.addComponent(memberCheckInTitleLbl)
				.addContainerGap(163, Short.MAX_VALUE))
			.addGroup(gl_memberCheckInPanel.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_memberCheckInPanel.createParallelGroup(Alignment.LEADING)
					.addComponent(memberNameLbl_CI)
					.addComponent(clubNameLbl_MCI))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_memberCheckInPanel.createParallelGroup(Alignment.LEADING)
					.addComponent(memberCheckIncb, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_memberCheckInPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(checkInBtn)
						.addComponent(memberNameTxtField_CI, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)))
				.addGap(61))
	);
	gl_memberCheckInPanel.setVerticalGroup(
		gl_memberCheckInPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_memberCheckInPanel.createSequentialGroup()
				.addGap(5)
				.addComponent(memberCheckInTitleLbl)
				.addGap(76)
				.addGroup(gl_memberCheckInPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(memberNameTxtField_CI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(memberNameLbl_CI))
				.addGap(12)
				.addGroup(gl_memberCheckInPanel.createParallelGroup(Alignment.TRAILING)
					.addComponent(memberCheckIncb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(clubNameLbl_MCI))
				.addGap(26)
				.addComponent(checkInBtn)
				.addContainerGap(21, Short.MAX_VALUE))
	);
	memberCheckInPanel.setLayout(gl_memberCheckInPanel);
	
	generateMemberBillPanel = new JPanel();
	layeredPane.add(generateMemberBillPanel, "name_1438280011423400");
	
	memberBillTitleLbl = new JLabel("GENERATE MEMBER BILL");
	
	memberNameLbl_GMB = new JLabel("Member First Name:");
	
	memberNametxtField_GMB = new JTextField();
	memberNametxtField_GMB.setColumns(10);
	
	generateBillBtn = new JButton("Generate Bill");
	
	GroupLayout gl_generateMemberBillPanel = new GroupLayout(generateMemberBillPanel);
	gl_generateMemberBillPanel.setHorizontalGroup(
		gl_generateMemberBillPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_generateMemberBillPanel.createSequentialGroup()
				.addGroup(gl_generateMemberBillPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_generateMemberBillPanel.createSequentialGroup()
						.addGap(147)
						.addComponent(memberBillTitleLbl))
					.addGroup(gl_generateMemberBillPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(memberNameLbl_GMB)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(memberNametxtField_GMB, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(65, Short.MAX_VALUE))
			.addGroup(Alignment.TRAILING, gl_generateMemberBillPanel.createSequentialGroup()
				.addContainerGap(315, Short.MAX_VALUE)
				.addComponent(generateBillBtn)
				.addContainerGap())
	);
	gl_generateMemberBillPanel.setVerticalGroup(
		gl_generateMemberBillPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_generateMemberBillPanel.createSequentialGroup()
				.addGap(5)
				.addComponent(memberBillTitleLbl)
				.addGap(76)
				.addGroup(gl_generateMemberBillPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(memberNameLbl_GMB)
					.addComponent(memberNametxtField_GMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
				.addComponent(generateBillBtn)
				.addContainerGap())
	);
	generateMemberBillPanel.setLayout(gl_generateMemberBillPanel);
	
	removeMemberAccPanel = new JPanel();
	layeredPane.add(removeMemberAccPanel, "name_1438283332884000");
	
	removeMemberTitleLbl = new JLabel("REMOVE A MEMBER ");
	
	memberNameLbl_RMA = new JLabel("Member First Name:");
	
	memberNametxtField_RMA = new JTextField();
	memberNametxtField_RMA.setColumns(10);
	
	removeMemberBtn = new JButton("Remove Member");
	
	GroupLayout gl_removeMemberAccPanel = new GroupLayout(removeMemberAccPanel);
	gl_removeMemberAccPanel.setHorizontalGroup(
		gl_removeMemberAccPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_removeMemberAccPanel.createSequentialGroup()
				.addGroup(gl_removeMemberAccPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_removeMemberAccPanel.createSequentialGroup()
						.addGap(158)
						.addComponent(removeMemberTitleLbl))
					.addGroup(gl_removeMemberAccPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(memberNameLbl_RMA)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(memberNametxtField_RMA, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(53, Short.MAX_VALUE))
			.addGroup(Alignment.TRAILING, gl_removeMemberAccPanel.createSequentialGroup()
				.addContainerGap(315, Short.MAX_VALUE)
				.addComponent(removeMemberBtn)
				.addContainerGap())
	);
	gl_removeMemberAccPanel.setVerticalGroup(
		gl_removeMemberAccPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_removeMemberAccPanel.createSequentialGroup()
				.addGap(5)
				.addComponent(removeMemberTitleLbl)
				.addGap(70)
				.addGroup(gl_removeMemberAccPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(memberNametxtField_RMA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(memberNameLbl_RMA))
				.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
				.addComponent(removeMemberBtn)
				.addContainerGap())
	);
	removeMemberAccPanel.setLayout(gl_removeMemberAccPanel);
	
	displayMemberInfoPanel = new JPanel();
	layeredPane.add(displayMemberInfoPanel, "name_1438501849821700");
	
	displayMemberInfoTitleLbl = new JLabel("DISPLAY MEMBER INFO.");
	
	memberNameLbl_DMI = new JLabel("Member First Name:");
	
	memberNametxtField_DMI = new JTextField();
	memberNametxtField_DMI.setColumns(10);
	
	displayMemberBtn = new JButton("Display Member");
	
	GroupLayout gl_displayMemberInfoPanel = new GroupLayout(displayMemberInfoPanel);
	gl_displayMemberInfoPanel.setHorizontalGroup(
		gl_displayMemberInfoPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_displayMemberInfoPanel.createSequentialGroup()
				.addGroup(gl_displayMemberInfoPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_displayMemberInfoPanel.createSequentialGroup()
						.addGap(148)
						.addComponent(displayMemberInfoTitleLbl))
					.addGroup(gl_displayMemberInfoPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(memberNameLbl_DMI)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(memberNametxtField_DMI, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(57, Short.MAX_VALUE))
			.addGroup(Alignment.TRAILING, gl_displayMemberInfoPanel.createSequentialGroup()
				.addContainerGap(315, Short.MAX_VALUE)
				.addComponent(displayMemberBtn)
				.addContainerGap())
	);
	gl_displayMemberInfoPanel.setVerticalGroup(
		gl_displayMemberInfoPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_displayMemberInfoPanel.createSequentialGroup()
				.addGap(5)
				.addComponent(displayMemberInfoTitleLbl)
				.addGap(74)
				.addGroup(gl_displayMemberInfoPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(memberNameLbl_DMI)
					.addComponent(memberNametxtField_DMI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
				.addComponent(displayMemberBtn)
				.addContainerGap())
	);
	displayMemberInfoPanel.setLayout(gl_displayMemberInfoPanel);

}

	
//////////////////////////////////////////////////////
/////This method contains all the code for creating events
//////////////////////////////////////////////////////
	public void createEvents() {
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(addMemberPanel);
			}
		});
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(memberCheckInPanel);
			}
	
		});
		
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(generateMemberBillPanel);
			}
		});
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(removeMemberAccPanel);
			}
		});
		
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(displayMemberInfoPanel);
			}
		});
		
		addMemberSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Member Added.");
				;
				if (rbAddMemTypeSingle.isSelected()) {
					makeNewSingleMember(memberNameTxtField.getText(),memberBirthdayTxtField.getText(),addMemberCb.getSelectedIndex());
				}else {
					makeNewMultiMember(memberNameTxtField.getText(),memberBirthdayTxtField.getText());
				}
				
				memberNameTxtField.setText("");
				memberBirthdayTxtField.setText("");
			}
		});	
		
		checkInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				memberCheckIn(memberNameTxtField_CI.getText(), memberCheckIncb.getSelectedIndex());
				memberNameTxtField_CI.setText("");
			}
		});
		
		generateBillBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			printBill(memberNametxtField_GMB.getText());
			memberNametxtField_GMB.setText("");
		}
	});
	
		removeMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeMember(memberNametxtField_RMA.getText());
				memberNametxtField_RMA.setText("");
			}
		});
	
		displayMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				printMemberInfo(memberNametxtField_DMI.getText());
				memberNametxtField_DMI.setText("");
			}
		});
		
		rbAddMemTypeMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbAddMemTypeMulti.isSelected()) {
					addMemberCb.setVisible(false);
				}
			}
		});
		
		rbAddMemTypeSingle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbAddMemTypeSingle.isSelected()) {
					addMemberCb.setVisible(true);
				}
			}
		});
		
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ret = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(homePanel);
				
			}
		});
		
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setModal(true);
				about.setVisible(true);
			}
		});
		
		
		
		
		
	}
	// method allows me to switch panels on Jframe 
	public void switchPanels(JPanel Panel) {

		layeredPane.removeAll();
		layeredPane.add(Panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private Member makeNewSingleMember(String inputMemberName, String inputBirthday, int clubPickIndex) {
		int inputId = idNum;
		idNum++;
		Club clubPick = clubList.get(clubPickIndex);
		SingleClubMember newClubMember = new SingleClubMember("SINGLE", inputMemberName, inputId, inputBirthday,
				clubPick);
		memberList.add(newClubMember);
		helper.append(newClubMember);
		return newClubMember;
	}
	private static Member makeNewMultiMember(String inputMemberName, String inputBirthday ) {
		int inputId = idNum;
		idNum++;
		int MembershipPoints = 0;
		MultiClubMember newClubMember = new MultiClubMember("MULTI", inputMemberName, inputId, inputBirthday,
				MembershipPoints);
		memberList.add(newClubMember);
		helper.append(newClubMember);
		return newClubMember;

	}
	private static void memberCheckIn(String input,int clubPickIndex ) {
		
		String currentClub = clubList.get(clubPickIndex).getName();

		for (int i = 0; i < memberList.size(); i++) {
			if (input.equalsIgnoreCase(memberList.get(i).getName())) {
				String memType = memberList.get(i).getMemberType();
				if (memType.equalsIgnoreCase("single")) {
					SingleClubMember a = (SingleClubMember) memberList.get(i);
					for (Club c : clubList) {
						if (a.getClubName().equalsIgnoreCase(currentClub)) {
							JOptionPane.showMessageDialog(null,a.getName() + " has been checked in.");
							a.checkIn(c);
							return;
						} else {
							JOptionPane.showMessageDialog(null, " Error. " + a.getName() + " can only check in at " + (a.getClubName() + ". "));
							return;
						}
					}
				} else {
					for (Club c : clubList) {
						if (c.getName().equalsIgnoreCase(currentClub)) {
							MultiClubMember b = (MultiClubMember) memberList.get(i);
							int Points = b.getMembershipPoints() + 10;
							b.setMembershipPoints(Points);
							b.checkIn(c);
							helper.rewrite(memberList);
							JOptionPane.showMessageDialog(null, b.getName() + " has been checked in.");
							return;
						}
					}
				}
			}
		}JOptionPane.showMessageDialog(null, "Member doesn't exist.");
	}
	
	private static void printBill(String memberName ) {

		for (Member m : memberList) {
			if (memberName.equalsIgnoreCase(m.getName())) {
				m.printBill();
				return;
			} 
			
			
		}JOptionPane.showMessageDialog(null,"Member doesn't exist.");
	}
	
	private static void removeMember(String input) {
		int memberIndex = 0; 
		
		for (int i = 0; i < memberList.size(); i++) {
			if (input.equalsIgnoreCase(memberList.get(i).getName())) {
				memberIndex = i;
			}
		
	}
	memberList.remove(memberIndex);
	helper.rewrite(memberList);
	JOptionPane.showMessageDialog(null, "Member has been removed.");
	
	
	
}
	
	private static void printMemberInfo(String input) {
		for (Member m : memberList) {
			if (m.getName().equalsIgnoreCase(input)) {
				JOptionPane.showMessageDialog(null, m );
				return;
			}
				
			}
		JOptionPane.showMessageDialog(null,"Member doesn't exist.");
			
			;
		}
	}


