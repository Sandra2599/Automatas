/**
 * Crea un automata por defecto y permite crear uno de diferente manera
 * con valores nuevos
 */
package implementar;

/**
 *
 * @author Paulino Salas
 */
public class Automata {

    private int Q; //Conjunto finito de estado
    private String alpha; //alfabeto
    private int q0; //Estado inicial
    private String F; //conjunto de estados finales
    private int mte[][]; //Matriz de estado

    /**
     * Automata inicial, crea un automata de prueba inicializando
     * todas las variables de la clase
     */
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
        System.out.println("Automata de Prueba cargado");
    }

    /**
     * Constructor con parametros crea un nuevo automata a partir de los 
     * parametros enviados, da nuevos valores a las variables declaradas.
     * @param Q  Conjunto finito de estados
     * @param alpha alfabeto
     * @param q0 Estado inicial
     * @param F Conjunto de Estados finales
     * @param mte Matriz de estado
     */
    public Automata(int Q, String alpha, int q0, String F, int[][] mte) {
        this.Q = Q;
        this.alpha = alpha;
        this.q0 = q0;
        this.F = F;
        this.mte = mte;
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

    /**
     * Valida si q y s son mayores a Q y a la longitud del alfabeto. Devuelve el nuevo estado
     * @param q Estado inicial
     * @param s Nuevo estado
     * @return Nuevo estado o -1 si no se encuentra en el alfabeto
     */
    public int getMte(int q, int s) {
        if ((q < Q) && (s < alpha.length())&&(s>-1)) {
            return mte[q][s];
        } else {
            return -1;
        }
    }

    public void setMte(int[][] mte) {
        this.mte = mte;
    }

}
