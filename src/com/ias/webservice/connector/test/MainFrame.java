package com.ias.webservice.connector.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ias.webservice.connector.TroiaMessage;
import com.ias.webservice.connector.TroiaVariable;
import com.ias.webservice.connector.TroiaWSCryptoUtils;
import com.ias.webservice.connector.WebServiceResponse;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	// user information
	private JButton btLogOut = new JButton();

	// request
	private JComboBox cmbServiceList = new JComboBox();
	private JButton btListServices = new JButton();
	private JTextPane tfParameters = new JTextPane();
	private JTextPane tfExtraVariables = new JTextPane();
	private JTextField tfRequestID = new JTextField();
	private JComboBox cmbEncodingType = new JComboBox();
	private JCheckBox chkRequestCompress = new JCheckBox();
	private JCheckBox chkRequestPermanet = new JCheckBox();
	private JButton btCall = new JButton();

	// result
	private JTextPane tfResult = new JTextPane();
	private JTextField tfResultRequestID = new JTextField();
	private JTextField tfErrorStatus = new JTextField();
	private JTable tblMessages = new JTable();
	private JTable tblVariable = new JTable();

	/**
	 * This constructor calls components's methods.
	 *
	 * @throws RemoteException
	 */
	public MainFrame() throws RemoteException {
		initFrame();
		initComponents();
		setDefaultParameters();
		fillServicesList();
	}

	/**
	 * Properties of this form components. Warning: When you change or add a
	 * component please be careful. Adjusting component's "preferred size" and
	 * the order of adding codes are important point.
	 */
	private void initComponents() {

		JPanel pMain = new JPanel(new BorderLayout());
		pMain.setBorder(new EmptyBorder(10, 5, 5, 5));

		//////
		JPanel pUserInfoPanel = new JPanel(new GridLayout(1, 6));
		pUserInfoPanel.setBorder(BorderFactory.createTitledBorder("User Information"));
		pUserInfoPanel.add(new JLabel("abc"));
		pUserInfoPanel.add(new JLabel("abc"));
		pUserInfoPanel.add(new JLabel("abc"));
		pUserInfoPanel.add(new JLabel("abc"));
		pUserInfoPanel.add(new JLabel("abc"));

		btLogOut.setPreferredSize(new Dimension(0, 25));
		pUserInfoPanel.add(btLogOut);

		pMain.add(pUserInfoPanel, BorderLayout.NORTH);
		//////

		JPanel pRequest = new JPanel(new BorderLayout());
		pRequest.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Request"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		JPanel pServices = new JPanel(new BorderLayout());
		pServices.add(cmbServiceList);
		pServices.add(btListServices, BorderLayout.EAST);
		pRequest.add(pServices, BorderLayout.NORTH);

		JPanel pRequestParams = new JPanel(new BorderLayout());
		pRequestParams.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

		JPanel pParametersPanel = new JPanel(new BorderLayout());
		pParametersPanel.add(new JLabel("Parameters"), BorderLayout.NORTH);

		JScrollPane paramsScroll = new JScrollPane(tfParameters);
		pParametersPanel.add(paramsScroll, BorderLayout.CENTER);
		pRequestParams.add(pParametersPanel, BorderLayout.CENTER);
		pRequest.add(pRequestParams, BorderLayout.CENTER);

		JPanel pOtherParamsAndCAllButton = new JPanel(new BorderLayout());
		pOtherParamsAndCAllButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
		pOtherParamsAndCAllButton.add(btCall, BorderLayout.SOUTH);

		JPanel pOtherRequestParams = new JPanel(new GridLayout(5, 2, 5, 5));

		pOtherRequestParams.add(new JLabel("Permanent"));
		pOtherRequestParams.add(chkRequestPermanet);
		pOtherRequestParams.add(new JLabel(""));
		pOtherRequestParams.add(chkRequestCompress);
		pOtherRequestParams.add(new JLabel("Request Id"));
		pOtherRequestParams.add(tfRequestID);
		pOtherRequestParams.add(new JLabel("Encoding"));
		pOtherRequestParams.add(cmbEncodingType);
		pOtherRequestParams.add(new JLabel(""));
		pOtherRequestParams.add(new JLabel(""));

		pOtherParamsAndCAllButton.add(pOtherRequestParams);

		pRequestParams.add(pOtherParamsAndCAllButton, BorderLayout.EAST);

		JPanel pExtraVariables = new JPanel(new BorderLayout());
		pExtraVariables.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		pExtraVariables.add(new JLabel("Extra Variables"), BorderLayout.NORTH);

		JScrollPane extravarsscroll = new JScrollPane(tfExtraVariables);
		pExtraVariables.add(extravarsscroll);

		pParametersPanel.add(pExtraVariables, BorderLayout.SOUTH);

		pMain.add(pRequest);

		//////
		JPanel pResultPanel = new JPanel(new BorderLayout());
		pResultPanel.setBorder(BorderFactory.createTitledBorder("Result"));

		JPanel pResultMainVertical = new JPanel(new GridLayout(2, 1, 3, 3));

		JPanel pResultHorizontal = new JPanel(new BorderLayout());

		JScrollPane resultScroll = new JScrollPane(tfResult);
		tfResult.setPreferredSize(new Dimension(10, 150));
		pResultHorizontal.add(resultScroll);

		JPanel rResultOther = new JPanel(new BorderLayout());
		rResultOther.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

		JPanel resultRequest = new JPanel(new GridLayout(1, 5, 3, 3));
		resultRequest.add(new JLabel("Request Id"));
		resultRequest.add(tfResultRequestID);

		JPanel resultstatus = new JPanel(new BorderLayout());
		resultstatus.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
		JLabel statuslabel = new JLabel("SYS_STATUS / SYS_STATUSERROR");
		statuslabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		resultstatus.add(statuslabel, BorderLayout.WEST);
		resultstatus.add(tfErrorStatus);

		rResultOther.add(resultRequest, BorderLayout.WEST);
		rResultOther.add(resultstatus);

		pResultHorizontal.add(rResultOther, BorderLayout.SOUTH);

		pResultMainVertical.add(pResultHorizontal);

		JPanel pResultTableHorizontal = new JPanel(new GridLayout(1, 2, 3, 3));

		JScrollPane messagescroll = new JScrollPane(tblMessages);
		messagescroll.setPreferredSize(new Dimension(0, 120));
		pResultTableHorizontal.add(messagescroll);

		JScrollPane variablescroll = new JScrollPane(tblVariable);
		variablescroll.setPreferredSize(new Dimension(0, 120));
		pResultTableHorizontal.add(variablescroll);

		pResultMainVertical.add(pResultTableHorizontal);

		pResultPanel.add(pResultMainVertical);

		pMain.add(pResultPanel, BorderLayout.SOUTH);
		//////

		this.setContentPane(pMain);
		tblVariable.setCellSelectionEnabled(true);

		btLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					if (LoginFrame.Connector.iSessionInfo.getSessionId() != null) {
						JOptionPane.showMessageDialog(MainFrame.this, "Redirecting to Login Page...", "Web Service 2.0 Test Tool",
								JOptionPane.INFORMATION_MESSAGE);
						MainFrame.this.setVisible(false);
						LoginFrame mainframe = new LoginFrame();
						LoginFrame.Connector.iService.logout(LoginFrame.Connector.iSessionInfo.getSessionId());

						mainframe.setVisible(true);
					}

				} catch (RemoteException ex) {
					Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		});

		cmbServiceList.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
		btListServices.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fillServicesList();
			}

		});

		btCall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				callService();
			}

		});

		tfExtraVariables.setPreferredSize(new java.awt.Dimension(0, 40));

		chkRequestCompress.setEnabled(false);
		cmbEncodingType.setEditable(true);
		cmbEncodingType.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
		cmbEncodingType.setEnabled(false);

	}

	/**
	 * Essential properties for this class.
	 *
	 * @throws RemoteException
	 */
	private void initFrame() throws RemoteException {
		this.setSize(900, 820);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});
	}

	/**
	 * Created a message panel and give messages to users. An alternative
	 * message function.
	 *
	 * @param text
	 */
	public void setWarningMsg(String text) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane optionPane = new JOptionPane("An unexpected error is preventing the operation: \n" + text, JOptionPane.ERROR_MESSAGE);
		JDialog dialog = optionPane.createDialog("Error!");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}

	public void callService() {

		if (cmbEncodingType.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "Please select an encrypt charset like UTF-8, UTF-16 etc.", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}

		TroiaWSCryptoUtils.targetCharsetParam = cmbEncodingType.getSelectedItem().toString();

		try {
			// read parameters from gui
			String strServiceName = cmbServiceList.getSelectedItem().toString();
			String strParameters = tfParameters.getText();
			String strExtraVariables = tfExtraVariables.getText();
			boolean permanent = chkRequestPermanet.isSelected();
			boolean compress = chkRequestCompress.isSelected();
			int requestId = Integer.parseInt(tfRequestID.getText());

			// call service with parameters
			WebServiceResponse iResponse = LoginFrame.Connector.callService(strServiceName, strParameters, compress, permanent, strExtraVariables, requestId);

			// show result on gui
			tfResult.setText(iResponse.getStringResponse());
			tfErrorStatus.setText(iResponse.getSYSStatus() + " / " + iResponse.getSYSStatusError());
			tfResultRequestID.setText(String.valueOf(iResponse.RequestId()));

			// show message list on gui
			TroiaMessage[] messages = iResponse.Messages();
			DefaultTableModel modelMessages = (DefaultTableModel) tblMessages.getModel();
			modelMessages.getDataVector().removeAllElements();
			modelMessages.fireTableDataChanged();
			for (TroiaMessage message : messages) {
				modelMessages.insertRow(modelMessages.getRowCount(),
						new Object[] { message.getText(), message.getModule(), message.getType(), message.getNumber() });
			}

			// show variables on gui
			TroiaVariable[] variables = iResponse.Variables();
			DefaultTableModel iVariablesTableModel = (DefaultTableModel) tblVariable.getModel();
			iVariablesTableModel.getDataVector().removeAllElements();
			iVariablesTableModel.fireTableDataChanged();
			for (TroiaVariable variable : variables) {
				iVariablesTableModel.insertRow(iVariablesTableModel.getRowCount(),
						new Object[] { variable.getName(), variable.getType(), variable.getValue() });
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "An unexpected error is preventing the operation: \n" + e.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void fillServicesList() {
		cmbServiceList.removeAll();

		try {

			if (LoginFrame.Connector != null) {
				// clear combobox content
				cmbServiceList.removeAllItems();

				// add item for each service
				Vector<String> services = LoginFrame.Connector.getServiceList();
				for (int i = 0; i < services.size(); i++) {
					cmbServiceList.addItem(services.get(i));
				}
			}

		} catch (Exception e) {
			this.setWarningMsg(e.getMessage());
			e.printStackTrace();
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * Process on formWindowsClosed event.
	 *
	 * @param evt
	 */
	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		try {
			if (!"".equals(LoginFrame.Connector.iSessionInfo.getSessionId())) {
				LoginFrame.Connector.iService.logout(LoginFrame.Connector.iSessionInfo.getSessionId());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "An unexpected error is preventing the operation: \n" + e.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Inputs for components
	 */
	private void setDefaultParameters() {
		// Services Panel
		btLogOut.setText("Logout");
		btCall.setText("Call Service");
		btListServices.setText("Refresh Services List");

		// Request Panel
		tfParameters.setText(
				"<PARAMETERS><PARAM>5</PARAM><PARAM type=\"TABLE\"><MYTBL><ROW><COL1>row1 col1 value</COL1><COL2>row1 col1 value</COL2></ROW><ROW><COL1>row2 col1 value</COL1><COL2>row2 col2 value</COL2></ROW></MYTBL></PARAM><PARAM type=\"VECTOR\"><MYVEC><ITEM><NAME>TROIASYMBOL1</NAME><TYPE>STRING</TYPE><VALUE>value1</VALUE></ITEM><ITEM><NAME>TROIASYMBOL2</NAME><TYPE>LONG</TYPE><VALUE>3</VALUE></ITEM></MYVEC></PARAM></PARAMETERS>");
		tfExtraVariables.setText("SYS_BUILD,SYS_VERSION,WSLOCAL,WSMEMBER");

		cmbEncodingType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UTF-8" }));
		tfRequestID.setText("1");

		// Result Panel
		tfResultRequestID.setText("1");

		tblVariable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Name", "Type", "Value" }));
		tblMessages.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Text", "Module", "Type", "Number" }));

	}

	public static void main(String... strings) throws Exception {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setTitle("ortadan");

		mainFrame.setVisible(true);
	}
}
