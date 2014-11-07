/*
 * NovacomInstallerApp.java
 */

package ca.canucksoftware.novacominstaller;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class NovacomInstallerApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        NovacomInstallerView app = new NovacomInstallerView(this);
        app.getFrame().setResizable(false);
        app.getFrame().setSize(220, 140);
        app.getFrame().setTitle("Universal Novacom Installer");
        app.getFrame().setVisible(true);
        app.getFrame().requestFocus();

        show(app);
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of NovacomInstallerApp
     */
    public static NovacomInstallerApp getApplication() {
        return Application.getInstance(NovacomInstallerApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(NovacomInstallerApp.class, args);
    }
}
