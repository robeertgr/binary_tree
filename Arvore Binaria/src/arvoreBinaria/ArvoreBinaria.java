package arvoreBinaria;

import java.util.Scanner;

public class ArvoreBinaria {

	private No raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	/**
	 * Insere item na árvore
	 * 
	 * @param node  - nó raiz
	 * @param chave - número inteiro
	 */
	private void inserirNo(No node, int chave) {
		if (node == null) {
			node = new No(chave);
			raiz = node;
		} else if (chave < node.chave && node.esq == null) {
			node.esq = new No(chave);
			node.esq.pai = node;
		} else if (chave >= node.chave && node.dir == null) {
			node.dir = new No(chave);
			node.dir.pai = node;
		} else {
			if (chave < node.chave) {
				inserirNo(node.esq, chave);
			} else {
				inserirNo(node.dir, chave);
			}
		}
	}

	/**
	 * Busca a chave na árvore
	 * 
	 * @param node  - nó raiz
	 * @param chave - número a ser buscado
	 * @return
	 */

	private boolean buscar(No node, int chave) {
		if (node == null) {
			return false;
		} else if (node.chave == chave) {
			return true;
		} else {
			if (chave < node.chave) {
				return buscar(node.esq, chave);
			} else {
				return buscar(node.dir, chave);
			}
		}
	}

	/**
	 * Percurso pre ordem
	 * 
	 * @param node - nó raiz
	 */
	private void preOrdem(No node) {
		if (node != null) {
			System.out.print(node.chave + " - ");
			preOrdem(node.esq);
			preOrdem(node.dir);
		}
	}

	/**
	 * Percurso em ordem
	 * 
	 * @param node - nó raiz
	 */
	private void emOrdem(No node) {
		if (node != null) {
			emOrdem(node.esq);
			System.out.print(node.chave + " - ");
			emOrdem(node.dir);
		}
	}

	/**
	 * Percurso pós ordem
	 * 
	 * @param node - nó raiz
	 */
	private void posOrdem(No node) {
		if (node != null) {
			posOrdem(node.esq);
			posOrdem(node.dir);
			System.out.print(node.chave + " - ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao = -1, x = 0;
		boolean res = false;
		Scanner sc = new Scanner(System.in);
		ArvoreBinaria ab = new ArvoreBinaria();

		while (opcao != 0) {

			System.out.println("\n*******************************************************");
			System.out.println("                        M E N U                        ");
			System.out.println("*******************************************************");
			System.out.println(" 0 - Sair                                              ");
			System.out.println(" 1 - Inserção		                                   ");
			System.out.println(" 2 - Busca 					                           ");
			System.out.println(" 3 - Percurso Pré-Ordem			                       ");
			System.out.println(" 4 - Percurso Em-Ordem			                       ");
			System.out.println(" 5 - Percurso Pós-Ordem			                       ");
			System.out.print(" Opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 0:
				break;
			case 1: {
				System.out.println("Digite um valor: ");
				x = sc.nextInt();
				ab.inserirNo(ab.raiz, x);
				break;
			}
			case 2: {
				System.out.println("Digite um valor: ");
				x = sc.nextInt();
				long startTime = System.currentTimeMillis();
				res = ab.buscar(ab.raiz, x);
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;

				System.out.println("início = " + startTime);
				System.out.println("fim = " + endTime);
				System.out.println("tempo total = " + totalTime);

				System.out.println("A busca levou " + totalTime + " ms\n");
				if (res) {
					System.out.println("O elemento " + x + " foi encontrado!");
				} else {
					System.out.println("O elemento " + x + " não foi encontrado!");
				}
				break;
			}
			case 3: {
				System.out.println("Percurso Em-Ordem");
				ab.preOrdem(ab.raiz);
				break;
			}
			case 4: {
				System.out.println("Percurso Em-Ordem");
				ab.emOrdem(ab.raiz);
				break;
			}
			case 5: {
				System.out.println("Percurso Em-Ordem");
				ab.posOrdem(ab.raiz);
				break;
			}
			default:
				System.out.println("Opção inválida!");
			}
		}
		sc.close();
	}
}

