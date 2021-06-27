package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    public final static int TAILLE_PAR_DEFAUT = 6;
    private int capacite;


    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.v = new Vector<Object>(taille);
        this.capacite = taille;
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        v.add(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        Object o = v.remove(v.size() - 1);
        return o;
    }

    public Object sommet() throws PileVideException {
        return v.get(v.size() - 1);
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return v.size();
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return v.size() == capacite;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < v.size(); i++){
            s += v.get(i) + " ";
        }
        return "";
    }

    public boolean equals(Object o) {
         if(o instanceof Pile3){
            Pile3 myPile = (Pile3) o;
        
        if ( myPile.capacite() != this.capacite()){ 
            return false;
        }
        for( int i = 0; i<v.size(); i++) {
            if ( myPile.v.get(i) != this.v.get(i)){
                return false;
            }
            else {continue ;}
        
    }
    }return true; 
}

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
