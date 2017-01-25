package common;

import java.awt.Image;

import javax.swing.ImageIcon;

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
	
	
	//Function to resize an icon to fit the size of a label/button
	public static ImageIcon ResizeIcon(String path, float ResizeFactor)
	{
		ImageIcon imageIcon = new ImageIcon(Define.class.getResource(path)); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		image = image.getScaledInstance((int)(imageIcon.getIconWidth()*ResizeFactor), (int)(imageIcon.getIconHeight()*ResizeFactor),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(image);  // transform it back

		return imageIcon;
	}
}
