package net.d80harri.capoeira.ui;

import com.airhacks.afterburner.injection.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.d80harri.capoeira.ui.word.add.AddWordView;

/**
 * Created by d80harri on 22.09.16.
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AddWordView appView = new AddWordView();
        Scene scene = new Scene(appView.getView());
        stage.setTitle("Capoeira");

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        Injector.forgetAll();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
