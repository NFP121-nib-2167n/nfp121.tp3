package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        if(estVide())
            throw new PileVideException();
        return this.stk.peek();
    }

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile
    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return this.stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.stk.size() == this.capacite;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        Object[] temp = this.stk.toArray();
        
        for (int i = taille() - 1; i >= 0; i--) {
            s += temp[i].toString();
            if (i > 0)
                s += ", ";
        }
 
        return s + "]";
    }

    public boolean equals(Object o) {
        if(o instanceof Pile2){
            Pile2 o_1 = this;
            Pile2 o_2 = (Pile2) o;
            
            boolean isEqual = true;
         
            if (o_2.taille() != o_1.taille()) {
                return false;
            }
         
            while (o_1.estVide() == false) {
                try {
                    if (o_1.sommet() == o_2.sommet()) {
                        o_1.stk.pop();
                        o_2.stk.pop();
                    }
                    else {
                        isEqual = false;
                        break;
                    }
                }catch (Exception e) {
                    return false;
                }
            }
         
            return isEqual;
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return capacite;
    }


} // Pile2