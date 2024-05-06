public record Moneda(String base_code,
                     double usd,
                     double mxn,
                     double clp,
                     double ars) {

    @Override
    public String toString() {
        return "Moneda{" +
                "base_code='" + base_code + '\'' +
                ", usd=" + usd +
                ", mxn=" + mxn +
                ", clp=" + clp +
                ", ars=" + ars +
                '}';
    }
}
