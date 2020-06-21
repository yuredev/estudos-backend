public class Principal {
    private enum DiaDaSemana {
        SEGUNDA(2),
        TERCA(3),
        QUARTA(4),
        QUINTA(5),
        SEXTA(6),
        SABADO(7),
        DOMINGO(1);

        private int numero;
        public int getValor() {
            return this.numero;
        }
        DiaDaSemana(int numero) {
            this.numero = numero;
        }
    };

    public static void main(String[] args) {
        DiaDaSemana d = DiaDaSemana.SABADO;
        System.out.println(testaSwitch(d));

    }

    private static String testaSwitch(DiaDaSemana d) {
        return switch (d) {
            case SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA -> "Dia da semana " + d.getValor();
            case SABADO, DOMINGO -> "Fim de semana " + d.getValor();
        };
    }
}
