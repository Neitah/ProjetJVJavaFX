package view.codeBehind;


import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import launch.Launcher;
import modele.metier.Mur;
import modele.metier.Niveau;
import view.gestion.ManagerVue;


public class Fenetre {
    //privé sauf initialize
    @FXML
    private Rectangle mur;
    @FXML
    private Pane pane;

    @FXML
    public void initialize() {

        Niveau n = ManagerVue.getM().getNiveauEnCours();
        Rectangle r;
        Rectangle carre=new Rectangle();
        carre.layoutXProperty().bind(n.getCarreJoueur().getP().posx1Property());
        carre.layoutYProperty().bind(n.getCarreJoueur().getP().posy1Property());
        carre.setHeight(n.getCarreJoueur().getP().getPosx2()-n.getCarreJoueur().getP().getPosx1());
        carre.setWidth(n.getCarreJoueur().getP().getPosy2()-n.getCarreJoueur().getP().getPosy1());
        carre.setFill(Color.DODGERBLUE);

        for (Mur m: n.getLesMurs()) {
            r=new Rectangle(m.getP().getPosx1(),m.getP().getPosy1(),m.getP().getPosx2()-m.getP().getPosx1(),m.getP().getPosy2()-m.getP().getPosy1());
            r.setFill(Color.BLACK);
            pane.getChildren().add(r);
        }
        pane.getChildren().add(carre);
        ManagerVue.getStage().addEventFilter(KeyEvent.KEY_PRESSED, event-> ManagerVue.getM().traiterTouche(event.getCode()));
    }

}