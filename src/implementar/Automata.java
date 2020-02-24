/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementar;

/**
 *
 * @author zomby
 */
public class Automata {

    private int Q; //Conjuto finito de estado
    private String alpha; //alfabeto
    private int q0; //Estado inicial
    private String F; //conjunto de estados finales
    private int mte[][]; //Matriz de estado

    public Automata() {
        Q = 4;
        alpha = "01";
        q0 = 0;
        F = "0";
        mte = new int[Q][alpha.length()];
        mte[0][0] = 2;
        mte[0][1] = 1;
        mte[1][0] = 3;
        mte[1][1] = 0;
        mte[2][0] = 0;
        mte[2][1] = 3;
        mte[3][0] = 1;
        mte[3][1] = 2;
        System.out.println("automata creado");
    }


    public int getQ() {
        return Q;
    }

    public void setQ(int Q) {
        this.Q = Q;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public int getQ0() {
        return q0;
    }

    public void setQ0(int q0) {
        this.q0 = q0;
    }

    public String getF() {
        return F;
    }

    public void setF(String F) {
        this.F = F;
    }

    public int getMte(int q, int s) {
        if (q < Q && s < alpha.length()) {
            return mte[q][s];
        } else {
            return -1;
        }
    }

    public void setMte(int[][] mte) {
        this.mte = mte;
    }

}
