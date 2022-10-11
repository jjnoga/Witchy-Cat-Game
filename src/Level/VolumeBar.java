package Level;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Scripts.Sounds;

public class VolumeBar {
	protected boolean isActive;
    protected final int x = 150;
    protected final int bottomY = 500;
    protected final int topY = 22;
    protected final int fontX = 35;
    protected final int fontBottomY = 500;
    protected final int fontTopY = 62;
    protected final int width = 500;
    protected final int height = 50;
    static Sounds sound = new Sounds();

    private KeyLocker keyLocker = new KeyLocker();
    private Map map;
    private Key interactKey = Key.ESC;

    public VolumeBar(Map map) {
        this.map = map;
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,3));
        
        JButton volUp = new JButton("Volume Up");
        volUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.volumeUp();
			}
		});
        frame.add(volUp);
        
        JButton volDown = new JButton("Volume Down");
        volDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.volumeDown();
			}
		});
        frame.add(volDown);
        
        JButton mute = new JButton("Mute");
        mute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.volumeMute();
			}
		});
        frame.add(mute);
        
        frame.pack();
        frame.setVisible(true);
        
    }

    public void update() {
    	
    	 if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
             keyLocker.lockKey(interactKey);
         }
    	 else if (Keyboard.isKeyUp(interactKey)) {
             keyLocker.unlockKey(interactKey);
         }	 
    }	

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setInteractKey(Key interactKey) {
        this.interactKey = interactKey;
    }
    
    public Key getInteractKey()
    {
    	return this.interactKey;
    }

    public KeyLocker getKeyLocker()
    {
    	return keyLocker;
    }
}
