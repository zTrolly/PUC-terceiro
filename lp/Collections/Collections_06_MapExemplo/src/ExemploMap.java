import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ExemploMap {
	public static void main(String[] args) {
		boolean ignoreCase = true;
		String chave;
		
		for (String s: args)
			System.out.print(s + " ");
		System.out.println("\n");
		
		Map<String, Integer> mapeamento = new HashMap<String, Integer>();
		
		Integer UM = Integer.valueOf(1);
		for (int i = 0, n = args.length; i < n; i++) {
			if (ignoreCase)
				chave = args[i].toLowerCase().replaceAll("[^a-zA-Z áéíóúàâêãõçü]", "");
			else
				chave = args[i];
			
			Integer frequencia = mapeamento.get(chave);
			if (frequencia == null) {
				frequencia = UM;
			} else {
				int valor = frequencia.intValue();
				frequencia = Integer.valueOf(valor + 1);
			}
			mapeamento.put(chave, frequencia);
		}
		System.out.println(mapeamento);
		Map<String, Integer> mapeamentoOrdenado = new TreeMap<String, Integer>(mapeamento);
		System.out.println(mapeamentoOrdenado);
	}
}
