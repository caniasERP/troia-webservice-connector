package com.ias.webservice.connector.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.ias.webservice.connector.WebServiceConnector;
import com.ias.webservice.connector.LoginParams;

/**
 * Login form for TROIA Web Service Client Api.
 * Its used for testing web service deployment and TROIA Web Service Client Api
 *
 */
@SuppressWarnings("serial")
public final class LoginFrame extends JFrame implements ActionListener {

	public static final String FRAMETITLE = "Web Service 2.0 Connector Test Tool";

	// connector
	public static WebServiceConnector Connector;

	// service url
	private JTextField tfWSDLUrl = new JTextField();

	// login form elements
	private JButton btLogIn = new JButton();
	private JTextField tfAplicationServer = new JTextField();
	private JTextField tfUsername = new JTextField();
	private JTextField tfDBName = new JTextField();
	private JTextField tfDBServer = new JTextField();
	private JTextField tfClient = new JTextField();
	private JTextField tfVKey = new JTextField();
	private JTextField tfLCheck = new JTextField();
	private JPasswordField tfPasswordField = new JPasswordField();
	private JCheckBox chkCompression = new JCheckBox();
	private JCheckBox chkEncrypted = new JCheckBox();
	private JComboBox cmbLanguage = new JComboBox();

	public LoginFrame() {
		super(FRAMETITLE);

		// main frame properties
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		this.setSize(540, 360);
		this.setResizable(false);

		initComponents();

		// fill default values to login form elements
		setDefaultParameters();
	}

	/**
	 * Inputs for components
	 */
	public void setDefaultParameters() {

		// text fields
		tfWSDLUrl.setText("http://www.ias.com.tr:8080/CaniasWebService/services/CaniasWebService?WSDL");
		tfClient.setText("00");
		tfDBName.setText("IAS604");
		tfDBServer.setText("CANIAS");
		tfAplicationServer.setText("192.168.0.7/502");
		tfUsername.setText("btan");

		// checkboxes
		chkCompression.setText("Compression");
		chkEncrypted.setText("Encrypted");

		// buttons
		btLogIn.setText("Login");

		// combobox
		cmbLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "E", "D", "T" }));
	}

	/**
	 * Properties of this form components. Warning: When you change or add a
	 * component please be careful. Adjusting component's "preferred size" and
	 * the order of adding codes are important point.
	 */
	private void initComponents() {

		// main panel
		JPanel pMain = new JPanel(new BorderLayout());
		pMain.setBorder(new EmptyBorder(10, 5, 5, 5));

		// url panel
		JPanel pURL = new JPanel(new BorderLayout());
		pURL.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("WSDL URL"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		tfWSDLUrl.setPreferredSize(new Dimension(100, 25));
		pURL.add(tfWSDLUrl);
		pMain.add(pURL, BorderLayout.NORTH);

		JPanel pLoginPanel = new JPanel(new GridLayout(1, 2, 10, 10));
		pLoginPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Login Parameters"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));

		// start login left
		JPanel pLoginParamsLeft = new JPanel(new GridLayout(8, 2, 2, 2));

		pLoginParamsLeft.add(new JLabel("Language"));
		cmbLanguage.setEditable(true);
		cmbLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
		pLoginParamsLeft.add(cmbLanguage);

		pLoginParamsLeft.add(new JLabel("Client"));
		pLoginParamsLeft.add(tfClient);

		pLoginParamsLeft.add(new JLabel("DB Name"));
		pLoginParamsLeft.add(tfDBName);

		pLoginParamsLeft.add(new JLabel("DB Server"));
		pLoginParamsLeft.add(tfDBServer);

		pLoginParamsLeft.add(new JLabel("App Server"));
		pLoginParamsLeft.add(tfAplicationServer);

		pLoginParamsLeft.add(new JLabel(""));
		pLoginParamsLeft.add(new JLabel(""));

		pLoginParamsLeft.add(new JLabel("UserName"));
		pLoginParamsLeft.add(tfUsername);

		pLoginParamsLeft.add(new JLabel("Password"));
		pLoginParamsLeft.add(tfPasswordField);

		pLoginPanel.add(pLoginParamsLeft);
		// end of login left

		JPanel pLoginParamsRight = new JPanel(new GridLayout(8, 2));

		pLoginParamsRight.add(new JLabel("LCheck"));
		pLoginParamsRight.add(tfLCheck);

		pLoginParamsRight.add(new JLabel("VKey"));
		pLoginParamsRight.add(tfVKey);

		pLoginParamsRight.add(new JLabel(""));
		pLoginParamsRight.add(chkCompression);
		pLoginParamsRight.add(new JLabel(""));
		pLoginParamsRight.add(chkEncrypted);

		pLoginParamsRight.add(new JLabel(""));
		pLoginParamsRight.add(new JLabel(""));

		pLoginParamsRight.add(new JLabel(""));
		pLoginParamsRight.add(btLogIn);

		pLoginPanel.add(pLoginParamsRight);
		pMain.add(pLoginPanel);

		JPanel jLoginPanel = new JPanel();
		jLoginPanel.setLayout(new java.awt.GridBagLayout());

		btLogIn.setText("");
		btLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btLogIn.addActionListener(this);

		pMain.add(jLoginPanel, BorderLayout.SOUTH);

		this.getContentPane().add(pMain);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {

			String WSDLUrl = tfWSDLUrl.getText();

			String client = tfClient.getText();
			String language = cmbLanguage.getSelectedItem().toString();
			String dbServer = tfDBServer.getText();
			String dbName = tfDBName.getText();
			String appServer = tfAplicationServer.getText();
			String username = tfUsername.getText();
			String password = new String(tfPasswordField.getPassword());

			boolean bEncrypted = chkEncrypted.isSelected();
			boolean bCompression = chkCompression.isSelected();
			String lCheck = tfLCheck.getText();
			String vKey = tfVKey.getText();

			LoginParams iParams = new LoginParams(client, language, dbServer, dbName, appServer, username, password, bEncrypted, bCompression, lCheck, vKey);

			Connector = new WebServiceConnector(WSDLUrl);
			Connector.login(iParams);

			if (!"".equals(LoginFrame.Connector.getSessionInfo().getSessionId())) {

				String strMessage = "Login Successful. (" + LoginFrame.Connector.getSessionInfo().getSessionId() + ")";
				JOptionPane.showMessageDialog(this, strMessage, FRAMETITLE, JOptionPane.INFORMATION_MESSAGE);

				MainFrame mainFrame = new MainFrame();
				mainFrame.setTitle(LoginFrame.Connector.getSessionInfo().getSessionId());

				this.setVisible(false);
				mainFrame.setVisible(true);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Unexpected Error:" + "could not access to server.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
