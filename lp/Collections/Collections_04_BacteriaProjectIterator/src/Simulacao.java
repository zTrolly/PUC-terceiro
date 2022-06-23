import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Simulacao {
	public static void main(String[] args) {
		double lixo = 0;

		Collection<Bacteria> colonia = new HashSet<Bacteria>();
		Collection<Bacteria> novas = new HashSet<Bacteria>();
		colonia.add(new Bacteria());
		for (int i = 0; i < 10; i++) {
			Iterator<Bacteria> iter = colonia.iterator();
			while (iter.hasNext()) {
				Bacteria o = iter.next();
				lixo += o.getPeso() / 2;
				
				try {
					novas.add(o.clone());
				} catch (Exception e) {
					System.out.println("Bact�ria n�o clon�vel");
				}

				o.passaDia();
			}
			colonia.removeIf(item -> item.morreu());
			colonia.addAll(novas);
			novas.clear();
		}
		System.out.println("Tamanho da Col�nia: " + colonia.size());
		System.out.println("Lixo consumido: " + lixo);
	}

}
