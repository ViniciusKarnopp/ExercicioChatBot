import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ASSISTENTE UNIDERP");
        System.out.println("Olá! Sou o assistente virtual.");
        System.out.println("Como posso ajudar?");
        
        boolean executando = true;
        int aguardandoRa = 0;
        
        while (executando) {
            System.out.print("\nVocê: ");
            String input = scanner.nextLine().toLowerCase().trim();
            
            if (aguardandoRa == 1) {
                System.out.println("Bot: Beleza, registrei o RA " + input + " pra fila de atendimento. Fica de olho no painel.");
                aguardandoRa = 0;
                continue;
            }
            
            String intencao = "";
            
            if (input.equals("tchau") || input.equals("sair")) {
                intencao = "SAIR";
            } else if (input.contains("oi") || input.contains("olá") || input.equals("ola")) {
                intencao = "SAUDACAO";
            } else if (input.contains("biblioteca") && (input.contains("hora") || input.contains("horário") || input.contains("horario"))) {
                intencao = "HORARIO_BIBLIO";
            } else if (input.contains("biblioteca") && input.contains("livro")) {
                intencao = "EMPRESTIMO_LIVRO";
            } else if (input.contains("biblioteca")) {
                intencao = "BIBLIOTECA";
            } else if (input.contains("matrícula") || input.contains("matricula")) {
                intencao = "MATRICULA";
            } else if (input.contains("trancar") && input.contains("curso")) {
                intencao = "TRANCAR";
            } else if (input.contains("atestado") && input.contains("médico")) {
                intencao = "ATESTADO";
            } else if (input.contains("atendimento") || input.contains("dca")) {
                intencao = "DCA";
            } else if (input.contains("obrigado") || input.contains("vlw")) {
                intencao = "AGRADECIMENTO";
            } else {
                intencao = "FALLBACK";
            }
            
            if (intencao.equals("SAIR")) {
                System.out.println("Bot: Até mais!");
                executando = false;
            } else if (intencao.equals("SAUDACAO")) {
                System.out.println("Bot: Olá! Como posso ajudar?");
            } else if (intencao.equals("HORARIO_BIBLIO")) {
                System.out.println("Bot: O horário da biblioteca é das 07h às 22h, de segunda a sexta.");
            } else if (intencao.equals("EMPRESTIMO_LIVRO")) {
                System.out.println("Bot: Você pode pegar até 3 livros por vez mostrando sua carteirinha.");
            } else if (intencao.equals("BIBLIOTECA")) {
                System.out.println("Bot: A biblioteca fica no bloco principal. Digite 'horário biblioteca' se quiser saber a hora que fecha.");
            } else if (intencao.equals("MATRICULA")) {
                System.out.println("Bot: Para realizar sua matrícula, acesse o portal acadêmico.");
            } else if (intencao.equals("TRANCAR")) {
                System.out.println("Bot: Poxa, quer mesmo trancar? Isso tem que ser visto direto no portal do aluno ou com o coordenador.");
            } else if (intencao.equals("ATESTADO")) {
                System.out.println("Bot: O atestado médico deve ser anexado no portal do aluno em até 72 horas úteis.");
            } else if (intencao.equals("DCA")) {
                System.out.println("Bot: Pra eu te colocar na fila do DCA, digita só o número do seu RA aí:");
                aguardandoRa = 1;
            } else if (intencao.equals("AGRADECIMENTO")) {
                System.out.println("Bot: Por nada!");
            } else if (intencao.equals("FALLBACK")) {
                System.out.println("Bot: Não entendi. Desculpe, tente novamente");
            }
        }
        
        scanner.close();
    }
}