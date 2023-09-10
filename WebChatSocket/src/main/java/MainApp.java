
import java.awt.EventQueue;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.websocket.DeploymentException;

import client.MyClientEndpoint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMessage;
	private JButton btnSendMessage;
	private JTextArea textAreaMessage;
	private MyClientEndpoint client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(frame);
					
					frame.connectWebSocketServer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		setTitle("WebSocket Chat Room - Client Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 256);
		this.contentPane = new JPanel();
		this.contentPane.setToolTipText("");
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.textFieldMessage = new JTextField();
		this.textFieldMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		this.textFieldMessage.setBounds(10, 11, 250, 20);
		this.contentPane.add(this.textFieldMessage);
		this.textFieldMessage.setColumns(10);
		
		this.btnSendMessage = new JButton("Send Message");
		this.btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		this.btnSendMessage.setBounds(281, 10, 132, 23);
		this.contentPane.add(this.btnSendMessage);
		
		this.textAreaMessage = new JTextArea();
		this.textAreaMessage.setBounds(10, 54, 403, 154);
		this.contentPane.add(this.textAreaMessage);
	}
	
	public void connectWebSocketServer() throws URISyntaxException, DeploymentException, IOException {
		this.client = new MyClientEndpoint(textAreaMessage);
	}
	
	public void sendMessage() {
		String message = textFieldMessage.getText();
		try {
			this.client.sendMessage(message);
			textFieldMessage.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

