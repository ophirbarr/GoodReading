package common;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import client.ClientInterface;

import java.lang.Math;

/**
 * This class contains defines for flags/statuses etc. and general help functions
 * @author יאיר בלין
 */
public class Define {
	
//#SystemUser
	//_userStatus:
	public static final int USER_DISCONNECTED = 0;
	public static final int USER_CONNECTED = 1;
	public static final int USER_WAITING = 2;
	public static final int USER_BLOCKED = 3;

//#Customer
	//_accountType:
	public static final int ACCOUNT_PER_BOOK = 0;
	public static final int ACCOUNT_MONTHLY = 1;
	public static final int ACCOUNT_YEARLY = 2;

	//_accountStatus
	public static final boolean ACCOUNT_NO_PERMISSION = false;
	public static final boolean ACCOUNT_FULL_PERMISSION = true;

	//_waitingForChangeType
	public static final int DO_NOT_CHANGE = 0;
	public static final int CHANGE_TO_MONTHLY = 1;
	public static final int CHANGE_TO_YEARLY = 2;
	
	public static final int FROM_USER_TO_CUSTOMER = 3;
	
	//PopUpMessageType
	public static final int Error = 0;
	public static final int Notice = 1;
	public static final int Edit = 2;
	public static final int Like = 3;
	public static final int Build = 4;
	
	
	/**
	 * Function to resize an icon to fit the size of a label/button
	 * @param path The icon file path
	 * @param componentWidth The component Width
	 * @param componentHeight The component Height
	 * @return An ImageIcon in the component size.
	 */
	public static ImageIcon ResizeIcon(String path, int componentWidth, int componentHeight)
	{
		ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		
		int IconWidth = imageIcon.getIconWidth();
		int IconHeight = imageIcon.getIconHeight();
		
		float ResizeFactor = Math.min(((float)componentWidth/IconWidth),((float)componentHeight/IconHeight));

		image = image.getScaledInstance((int)(IconWidth*ResizeFactor), (int)(IconHeight*ResizeFactor), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(image);  // transform it back

		return imageIcon;
	}
	
	
	/**
	 * @param messageText String of the message to be displayed.
	 * @param Type The type of the message. May be: Error(0), Notice(1), Edit(2), Like(3), Build(4).
	 */
	public  static void PopUp(String msg, int type)
	{
		JLabel lblItIsA = new JLabel();
		lblItIsA.setHorizontalAlignment(SwingConstants.CENTER);
		lblItIsA.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItIsA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItIsA.setPreferredSize(new Dimension(350,110));
		lblItIsA.setText("<html><div style='text-align: center;'>" + msg + "</div></html>");

		String path = "", title = "";
		switch(type)
		{
		case Define.Error:
			path = "/design/image6481.png";
			title = "Error";
			break;
		case Define.Notice:
			path = "/design/g526.png";
			title = "Notice";
			break;
		case Define.Edit:
			path = "/design/g274.png";
			title = "Edit";
			break;
		case Define.Like:
			path = "/design/g362.png";
			title = "Like";
			break;
		case Define.Build:
			path = "/design/g450.png";
			title = "Build";
			break;
		}
		
		JOptionPane.showOptionDialog(null, lblItIsA, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, Define.ResizeIcon(Define.class.getResource(path).getPath(), 60, 60), null, null);
	}
}
