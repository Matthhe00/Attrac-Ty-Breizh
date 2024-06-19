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
    private ToggleButton button1, button2;

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
        this.button1 = new ToggleButton("L'influence du nombre \nde commune sur \nl'investissement culturelle");
        this.button1.setId("1");

        this.button2 = new ToggleButton("L'influence de l'investissement culturelle sur le nombre de commune");
        this.button2.setId("2");
    }

    public Scene creerSceneStatistique() {
        Pane root = creerRootStatistique("0");
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootStatistique(String val) {
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root, val);
        return root;
    }

    public void configurerComposants(Pane root, String val) {
        root.getChildren().add(this.navBarre);
        configurerToggleButton(button1, 50, 200, "my-button-toggle", root, 300, 200);
        configurerToggleButton(button2, 50, 400, "my-button-toggle", root, 200, 200);
        if(val.equals("1")) {
            this.barChart1 = nbCommuneInvesti1();
            this.barChart2 = nbCommuneInvesti2();
            configurerBarChart(this.barChart1, 350, 150, 400, 350, "bar-chart", root);
            configurerBarChart(this.barChart2, 800, 150, 400, 350, "bar-chart", root);
        } else if (val.equals("2")) {
            // this.barChart = nbCommuneInvesti(root);
        } else {
            configurerLabel(this.label, 300, 50, "my-label", root);
        }
    }

    private void configurerToggleButton(ToggleButton button, int x, int y, String styleClass, Pane root, int width, int height) {
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(width, height);
        button.getStyleClass().add(styleClass);
        root.getChildren().add(button);
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
        BarChart<String, Number> barChartRet;
        // Définir les axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Numéro de Département");
        yAxis.setLabel("Nombre de Communes");

        // Créer le BarChart
        barChartRet = new BarChart<>(xAxis, yAxis);
        barChartRet.setTitle("Nombre de Communes par Département");

        // Ajouter les données
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("22", 348));
        series.getData().add(new XYChart.Data<>("29", 277));
        series.getData().add(new XYChart.Data<>("35", 333));
        series.getData().add(new XYChart.Data<>("56", 249));

        barChartRet.getData().add(series);

        return barChartRet;
    }

    public BarChart<String, Number> nbCommuneInvesti2() {
        BarChart<String, Number> barChartRet;

        // Définir les axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Numéro de Département");
        yAxis.setLabel("Investissement Culturelle");
    
        // Créer le BarChart
        barChartRet = new BarChart<>(xAxis, yAxis);
        barChartRet.setTitle("Investissement Culturelle par Département");
    
        // Ajouter les données
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("22", 6196596));
        series.getData().add(new XYChart.Data<>("29", 13672777));
        series.getData().add(new XYChart.Data<>("35", 26901579));
        series.getData().add(new XYChart.Data<>("56", 7107993));
    
        barChartRet.getData().add(series);
    
        return barChartRet;
    }

    public NavBarre getNavBarre() {
        return this.navBarre;
    }

    public ToggleButton getButton1() {
        return this.button1;
    }

    public ToggleButton getButton2() {
        return this.button2;
    }

    public void resetToggle() {
        this.button1.setSelected(false);
        this.button2.setSelected(false);
    }
}