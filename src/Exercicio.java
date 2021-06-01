import modelo.Lancamento;
import service.LancamentoService;

import java.util.List;

import static java.lang.System.out;
import static java.util.Comparator.comparing;

public class Exercicio {

    public static void main(String[] args) {
        List<Lancamento> lancamentos = new LancamentoService().listarLancamentos();

        out.println("Gastos ordenados por meses: ");
        lancamentos.stream()
                .sorted(comparing(Lancamento::getMes))
                .forEach(v -> out.println(v.getValor()));

        out.println("\nTodos os lançamentos da categoria 4: ");
        lancamentos.forEach(lancamento -> {
            lancamento.setCategoria(4);
            out.printf(String.valueOf(lancamento));
        });

        out.println("\nTotal da fatura do mês 5: ");
        lancamentos.stream().sorted(comparing(Lancamento::getMes).reversed());
        out.println(lancamentos.get(2).getValor()); // pegando mês por índice e exibindo o total da fatura

    }
}
