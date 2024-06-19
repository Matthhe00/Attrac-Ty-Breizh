package app.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Statistique  {
    private Stage primaryStage;
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private BarChart<String, Number> barChart1, barChart2;
    private Label label;
    private NavBarre navBarre;

    public Statistique(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_STATISTIQUE_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void initUIComponents() {
        this.barChart1 = new BarChart<>(new CategoryAxis(), new NumberAxis());
        this.barChart2 = new BarChart<>(new CategoryAxis(), new NumberAxis());
        this.label = new Label("Statistiques des Communes par Département");
    }

    public Scene creerSceneStatistique() {
        Pane root = creerRootStatistique(0);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootStatistique(int checkBox) {
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root, checkBox);
        return root;
    }

    public void configurerComposants(Pane root, int checkBox) {
        root.getChildren().add(this.navBarre);
        if(checkBox == 1) {
            this.barChart1 = nbCommuneInvesti1();
            this.barChart2 = nbCommuneInvesti2();
            configurerBarChart(this.barChart1, 300, 150, 500, 350, "bar-chart", root);
            configurerBarChart(this.barChart2, 300, 450, 500, 350, "bar-chart", root);
        } else if (checkBox == 2) {
            // this.barChart = nbCommuneInvesti(root);
        } else {
            configurerLabel(this.label, 300, 50, "my-label", root);
        }
    }


    private void configurerLabel(Label label, int x, int y, String styleClass, Pane root) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.getStyleClass().add(styleClass);
        root.getChildren().add(label);
    }

    private void configurerBarChart(BarChart<String, Number> barChart, int x, int y, int largeur, int hauteur, String styleClass, Pane root) {
        barChart.setLayoutX(x);
        barChart.setLayoutY(y);
        barChart.setPrefSize(largeur, hauteur);
        barChart.getStyleClass().add(styleClass);
        root.getChildren().add(barChart);
    }

    public BarChart<String, Number> nbCommuneInvesti1() {
        // Définir les axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Numéro de Département");
        yAxis.setLabel("Nombre de Communes");

        // Créer le BarChart
        this.barChart1 = new BarChart<>(xAxis, yAxis);
        this.barChart1.setTitle("Nombre de Communes par Département");

        // Ajouter les données
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("22", 348));
        series.getData().add(new XYChart.Data<>("29", 277));
        series.getData().add(new XYChart.Data<>("35", 333));
        series.getData().add(new XYChart.Data<>("56", 249));

        this.barChart1.getData().add(series);

        return this.barChart1;
    }

    public BarChart<String, Number> nbCommuneInvesti2() {
        // Définir les axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Numéro de Département");
        yAxis.setLabel("Investissement Culturelle");
    
        // Créer le BarChart
        this.barChart2 = new BarChart<>(xAxis, yAxis);
        this.barChart2.setTitle("Investissement Culturelle par Département");
    
        // Ajouter les données
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("22", 6196596));
        series.getData().add(new XYChart.Data<>("29", 13672777));
        series.getData().add(new XYChart.Data<>("35", 26901579));
        series.getData().add(new XYChart.Data<>("56", 7107993));
    
        this.barChart2.getData().add(series);
    
        return this.barChart2;
    }
    public NavBarre getNavBarre() {
        return this.navBarre;
    }
}