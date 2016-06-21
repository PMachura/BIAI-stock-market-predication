package przemek.BIAI.projekt.neuroph;


/**
 * Represents single row loaded from file
 *
 * @author Przemek
 */
public class SingleData {

    /**
     * Date
     */
    String date;
    /**
     * Index value
     */
    double[] values;

    public SingleData(String date, double[] values) {
        this.date = date;
        this.values = values.clone();

    }

    public SingleData(SingleData data) {
        this.values = data.values.clone();
        this.date = data.date;
    }

    public double findMax() {
        double max = 0;
        for (double v : values) {
            if (v > max) {
                max = v;
            }
        }
        System.out.println("max " + max);
        return max;

    }

    @Override
    public String toString() {
        String s = "SingleData{" + "date=" + date + " ";
        for (double v : values) {
            s += (Double.toString(v) + " ");
        }
        return s;
    }

}
