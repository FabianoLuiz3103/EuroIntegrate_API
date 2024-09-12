package br.com.challenge.euroIntegrate.webhook_chatbot;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/webhook")
public class Webhook {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<String> handleWebhook(@RequestBody String payload) {
        try {
            JsonNode jsonNode = objectMapper.readTree(payload);
            String intentName = jsonNode.path("queryResult").path("action").asText().toLowerCase();

            String responseMessage = "";

            switch (intentName) {
                case "missao":
                    responseMessage = "Nossa missão é promover o acesso à saúde e à qualidade de vida com tratamentos a preço justo e operação rentável, que assegure o crescimento sustentável da empresa e o compartilhamento do valor gerado com colaboradores e sociedade.";
                    break;
                case "visao":
                    responseMessage = "Nossa visão é ser uma das 3 maiores farmacêuticas de capital regional da América Latina. Buscamos ser líderes em prescrição médica no Brasil e referência em inovação e sustentabilidade. Com uma rentabilidade crescente, pretendemos ter 10% do nosso portfólio protegido e garantir que 30% das nossas vendas venham de operações internacionais.";
                    break;
                case "valores_agilidade":
                    responseMessage = "O valor **Agilidade** significa que dinamismo e simplicidade fazem parte do nosso DNA. Para nos mantermos competitivos, esses atributos devem estar presentes em todas as operações e processos da companhia.";
                    break;
                case "valores_comprometimento":
                    responseMessage = "O valor **Comprometimento** é fundamental para a valorização e crescimento dos colaboradores. Comprometimento com a empresa propicia a valorização dos talentos e é por isso que nossos talentos são frequentemente prestigiados por meio de aproveitamento interno.";
                    break;
                case "valores_desenvolvimento_sustentavel":
                    responseMessage = "O valor **Desenvolvimento Sustentável** abrange a boa gestão dos recursos humanos, financeiros e naturais. A base desse valor é o desenvolvimento dos colaboradores, solidez financeira, práticas comerciais saudáveis e ações para a preservação do meio ambiente.";
                    break;
                case "valores_foco_em_saude":
                    responseMessage = "O valor **Foco em Saúde** significa que nosso modelo de negócios participa de todos os segmentos farmacêuticos através de subsidiárias e parcerias estratégicas, mantendo um diálogo constante e atraindo novas parcerias.";
                    break;
                case "valores_empreendedorismo":
                    responseMessage = "O valor **Empreendedorismo** reflete nossa antecipação ao futuro e busca por novas e melhores formas de conduzir o negócio. Mantemos um espírito vanguardista, incentivando inovação e explorando novas oportunidades.";
                    break;
                case "valores_etica":
                    responseMessage = "O valor **Ética** está alinhado com o Código da companhia, leis e regulamentações vigentes. Nossos colaboradores devem pautar suas ações pela ética e transparência em todas as operações realizadas em nome da empresa.";
                    break;
                case "valores_igualdade":
                    responseMessage = "O valor **Igualdade (Diversidade)** zela por um ambiente imparcial e respeitoso. Estabelecemos compromissos relacionados à diversidade, justiça e igualdade nas relações entre colaboradores e demais públicos.";
                    break;
                case "valores_reinvestimento":
                    responseMessage = "O valor **Reinvestimento** acredita que assumir riscos é parte integral da atividade empresarial dinâmica. A geração de resultados positivos é reinvestida no próprio negócio para promover crescimento contínuo.";
                    break;
                case "valores_respeito":
                    responseMessage = "O valor **Respeito** valoriza nossa trajetória e capacidade de superação, refletindo nosso compromisso com o crescimento dos colaboradores e o desenvolvimento dos países onde atuamos. Mantemos respeito pelos povos e culturas com os quais nos relacionamos.";
                    break;
                case "valores_resultado":
                    responseMessage = "O valor **Resultado (Desempenho)** reconhece as diferentes contribuições para o alcance dos objetivos. Compartilhamos a riqueza gerada com colaboradores e sociedade através de programas de meritocracia, ampliação do acesso e investimentos sociais.";
                    break;
                case "codigoetica_clientes":
                    responseMessage = "**Clientes**: Comprometemo-nos a criar e ampliar a satisfação e lealdade dos nossos clientes através de práticas éticas. Nossa conduta visa a plena satisfação dos nossos clientes, demonstrando nosso compromisso com a qualidade e a ética.";
                    break;
                case "codigoetica_colaboradores":
                    responseMessage = "**Colaboradores**: Oferecemos uma visão clara sobre o comportamento esperado dos nossos colaboradores, evitando mal-entendidos e práticas oportunistas. O Código orienta os colaboradores sobre o norte moral a ser seguido para garantir um ambiente de trabalho ético e transparente.";
                    break;
                case "codigoetica_sociedade":
                    responseMessage = "**Sociedade**: Declaramos nosso desejo moral e expectativas de conduta, permitindo o julgamento sobre nossos atos. O Código estabelece o compromisso com práticas responsáveis e transparentes, refletindo nosso papel e responsabilidade social.";
                    break;
                case "codigoetica_grupo_eurofarma":
                    responseMessage = "**Grupo Eurofarma**: Regula nossa atuação com princípios de honestidade e transparência. Acreditamos na importância da ética empresarial na tomada de decisões responsáveis e exigimos integridade e elevada conduta profissional de nossos colaboradores e parceiros comerciais.";
                    break;
                case "codigoetica_direcao":
                    responseMessage = "**Direção**: Buscamos gerar valor e fortalecer nossa marca através de decisões prudentes e integridade. A Direção deve investir continuamente no crescimento e fortalecimento da marca, abrir novos mercados e tomar decisões prudentes para gerir os ativos da empresa com cuidado.";
                    break;
                case "codigoetica_parceiros_de_negocios":
                    responseMessage = "**Parceiros de Negócios**: Valorizamos relacionamentos baseados na confiança, transparência e ética. Buscamos melhorar continuamente a qualidade dos processos de negócios e encontrar novas oportunidades comerciais que agreguem valor aos nossos negócios.";
                    break;
                case "codigoetica_relacionamentos":
                    responseMessage = "**Relacionamentos**: Enfrentamos questões morais e éticas mantendo a integridade e respeito em nossas relações. O Código orienta como agir em situações de corrupção e injustiça, promovendo um ambiente de respeito e consideração mútua.";
                    break;
                case "clientes_e_consumidores":
                    responseMessage = "Nossa missão de promover o acesso à saúde e à qualidade de vida deve ser perseguida por todos os colaboradores, e nossos clientes são a razão da nossa existência. Comprometemo-nos a criar e ampliar a satisfação e a lealdade do cliente, oferecendo produtos de qualidade a preço justo, mantendo relações duradouras e sendo transparentes em toda comunicação. A qualidade no atendimento deve permear toda a empresa, e qualquer problema deve ser solucionado proativamente.";
                    break;
                case "padrao_grupo_eurofarma_clientes":
                    responseMessage = "No Grupo Eurofarma, o padrão de atendimento inclui respeito e cordialidade em todo assunto tratado, informações corretas e claras, proatividade na identificação de necessidades e possíveis riscos, e a proteção de informações pessoais conforme a Lei Geral de Proteção de Dados (LGPD). Opiniões pessoais não devem se sobrepor aos interesses da empresa e serviços remunerados de caráter pessoal não devem ser prestados aos clientes.";
                    break;
                case "orientacoes_praticas_clientes":
                    responseMessage = "Sempre adote uma comunicação honesta e transparente com nossos clientes. Caso o diálogo se torne inviável, peça a intervenção de seu gestor. Concentre-se em resolver problemas e mostrar atitude, antecipando-se a questões como atrasos. A qualidade no atendimento deve permear toda a empresa. Se houver dúvidas, encaminhe para a central de atendimento.";
                    break;
                case "importante_saber_clientes":
                    responseMessage = "São considerados clientes do Grupo Eurofarma: Consumidores em geral, Farmácias, Distribuidores, Hospitais, Clínicas médicas e veterinárias, Médicos, Profissionais da Área da Saúde, Outros Laboratórios Farmacêuticos clientes ou parceiros de negócio, e o Governo em ações licitatórias ganhas pelo Grupo Eurofarma.";
                    break;
                case "fornecedores":
                    responseMessage = "Nossos fornecedores devem estar alinhados com as metas operacionais e padrões éticos do Grupo Eurofarma. Selecionamos fornecedores com critérios justos e objetivos, evitando conflitos de interesse e práticas ilegais como a utilização de mão de obra infantil ou exploração. Formamos parcerias que agregam valor e rejeitamos práticas que comprometem o desenvolvimento sustentável.";
                    break;
                case "padrao_grupo_eurofarma_fornecedores":
                    responseMessage = "Contratamos fornecedores que agreguem valor e estejam alinhados com nossos objetivos estratégicos. Condenamos práticas ilegais e buscamos parcerias que rejeitam agressões ao meio ambiente. O Código de Conduta do Fornecedor garante uma relação de confiança, e não aceitamos serviços não previamente aprovados.";
                    break;
                case "orientacoes_praticas_fornecedores":
                    responseMessage = "A gestão de aquisições deve ser centralizada na Área de Suprimentos para garantir qualidade, atendimento, custo-benefício e conformidade com a política de suprimentos. Não aceitamos práticas anticoncorrenciais e qualquer processo que envolva pagamento a fornecedores deve ser executado em conformidade com a política de suprimentos.";
                    break;
                case "importante_saber_fornecedores":
                    responseMessage = "Exemplos de condutas anticoncorrenciais incluem combinação de preços, divisão de clientes e mercados, recusa de vendas, formação de cartel, aplicação de preços predatórios e práticas ilegais como pirataria e contrabando. Não aceitamos tais práticas e buscamos manter a competição saudável.";
                    break;
                case "central_atendimento_eurofarma":
                    responseMessage = "Para entrar em contato com o Grupo Eurofarma, utilize a Central de Atendimento Eurofarma pelo telefone 0800 704 3876 ou a Central de Atendimento Momenta pelo telefone 0800 703 1550. Também é possível acessar o site www.eurofarma.com.br para mais informações.";
                    break;
                case "boatos":
                    responseMessage = "Divulgamos apenas informações fundamentadas e previamente autorizadas pela Direção do Grupo Eurofarma, rejeitando qualquer boato ou informação incerta que possa causar danos ao ambiente interno ou ao mercado.";
                    break;
                case "concorrencia_justa":
                    responseMessage = "Respeitamos nossos concorrentes e buscamos uma concorrência saudável, justa e leal, sempre seguindo as normas e legislações aplicáveis.";
                    break;
                case "manipulacao_precos":
                    responseMessage = "Rejeitamos qualquer tentativa de manipular as condições de oferta e demanda, bem como qualquer mecanismo que afete artificialmente a formação de preços.";
                    break;
                case "produtos_ilegais":
                    responseMessage = "Não comercializamos produtos fora dos padrões legais, assegurando que nossas operações respeitem o mercado ético e regulamentado.";
                    break;
                case "relacionamento_saude":
                    responseMessage = "Valorizamos o patrocínio a profissionais de saúde para participação em eventos técnico-científicos, sempre visando o desenvolvimento profissional e respeitando as regulamentações do setor.";
                    break;
                case "patrocinio_eventos":
                    responseMessage = "Patrocinamos profissionais de saúde para eventos técnico-científicos, desde que essa relação seja clara e vise o desenvolvimento profissional.";
                    break;
                case "amostras_gratis":
                    responseMessage = "A distribuição de amostras grátis de medicamentos é feita exclusivamente para profissionais de saúde, em total conformidade com as leis e regulamentações.";
                    break;
                case "transparencia_publica":
                    responseMessage = "Nosso relacionamento com o setor público é regido por princípios de transparência e ética, assegurando a condução profissional de todas as interações.";
                    break;
                case "corrupcao":
                    responseMessage = "O Grupo Eurofarma é aderente às leis anticorrupção e não compactua com suborno, extorsão ou qualquer prática ilícita no relacionamento com o setor público.";
                    break;
                case "presentes_agentes_publicos":
                    responseMessage = "Não oferecemos ou aceitamos presentes de agentes públicos, primando sempre pela ética nas relações com o Governo em todas as esferas.";
                    break;
                case "imprensa_midias":
                    responseMessage = "Mantemos uma relação de diálogo contínuo, imparcial e verdadeiro com a imprensa, garantindo a confiabilidade e credibilidade da nossa comunicação.";
                    break;
                case "midias_sociais":
                    responseMessage = "Os princípios do nosso Código de Ética também se aplicam ao ambiente digital, garantindo que nossas ações nas mídias sociais reflitam nossos valores organizacionais.";
                    break;
                case "licitacoes":
                    responseMessage = "O Grupo Eurofarma não realiza ações que comprometam a integridade competitiva de licitações, mantendo uma postura ética e profissional em todas as negociações.";
                    break;
                case "atividade_politica":
                    responseMessage = "A participação em atividades político-partidárias é permitida apenas em caráter pessoal e não como representante da empresa.";
                    break;

                case "relacionamentos_internos_respeito_diversidade":
                    responseMessage = "O Grupo Eurofarma orienta que nas relações profissionais deve-se manter o respeito à diversidade de gêneros e pensamentos.";
                    break;
                case "relacionamentos_internos_equilibrio_vida_trabalho":
                    responseMessage = "O Grupo Eurofarma estimula o equilíbrio entre a vida social e a profissional, bem como entre o trabalho e a família, visando o bem-estar pessoal e profissional.";
                    break;
                case "relacionamentos_internos_preservacao_integridade_fisica":
                    responseMessage = "O Grupo Eurofarma apoia iniciativas de preservação à integridade física, à saúde e segurança no trabalho, e combate à dependência química e de álcool.";
                    break;
                case "relacionamentos_internos_assumir_responsabilidade":
                    responseMessage = "Todos os colaboradores devem assumir a responsabilidade por seus atos, reconhecendo os próprios erros e buscando não repeti-los.";
                    break;
                case "relacionamentos_internos_respeito_mutuo":
                    responseMessage = "O Grupo Eurofarma incentiva a prática de respeito mútuo, posturas de cooperação ativa e diligência.";
                    break;
                case "relacionamentos_internos_tratamento_justo":
                    responseMessage = "Conquista a confiança do grupo, aquele que estabelece, sempre, tratamento justo e equânime, sendo responsável em suas avaliações formais.";
                    break;
                case "relacionamentos_internos_assedio_moral_sexual":
                    responseMessage = "O Grupo Eurofarma repudia o assédio sexual e moral, que constrangem, humilham e prejudicam o ambiente de trabalho e a autoestima dos colaboradores.";
                    break;
                case "relacionamentos_internos_assedio_condutas_inaceitaveis":
                    responseMessage = "Condutas inaceitáveis incluem desqualificação pública, ameaça, falta de respeito com atribuições funcionais e solicitação de favorecimentos pessoais ou sexuais.";
                    break;
                case "postura_profissional_diretrizes":
                    responseMessage = "O Grupo Eurofarma estabelece que dignidade e respeito ao próximo são pilares para um ambiente de trabalho saudável e para o alcance de resultados.";
                    break;
                case "postura_profissional_integridade":
                    responseMessage = "É esperado que todos os colaboradores ajam com integridade de caráter, honestidade, retidão, lealdade e justiça.";
                    break;
                case "postura_profissional_respeito_valores":
                    responseMessage = "Os colaboradores devem seguir rigorosamente os valores do Grupo Eurofarma e comunicar qualquer ação que possa prejudicar a reputação da empresa.";
                    break;
                case "postura_profissional_alcool_drogas":
                    responseMessage = "A ingestão de bebidas alcoólicas de maneira não moderada e o uso de drogas ilícitas são práticas condenadas pelo Grupo Eurofarma.";
                    break;
                case "postura_profissional_pontualidade":
                    responseMessage = "A pontualidade e a disciplina são valores importantes e devem ser respeitados em todas as atividades profissionais.";
                    break;
                case "postura_profissional_aprendizado":
                    responseMessage = "O Grupo Eurofarma valoriza colaboradores que demonstram esforço contínuo para aprender e se desenvolver.";
                    break;

                case "conflito_interesses_definicao":
                    responseMessage = "O conflito de interesses ocorre quando os interesses pessoais, e/ou de familiares, interferem ou parecem interferir, direta ou indiretamente, com os interesses da empresa.";
                    break;
                case "conflito_interesses_orientacao":
                    responseMessage = "Os colaboradores devem evitar participar de decisões de negócios com organizações em que possuam interesses pessoais ou familiares. É necessário relatar conflitos ao Grupo Eurofarma.";
                    break;
                case "conflito_interesses_emprego_secundario":
                    responseMessage = "Antes de aceitar um emprego ou atividade secundária, os colaboradores devem obter aprovação do Grupo Eurofarma, para garantir que não haja conflito com os interesses da empresa.";
                    break;
                case "conflito_interesses_uso_inadequado_recursos":
                    responseMessage = "O uso inadequado de recursos da empresa, como telefone, equipamentos e materiais de escritório para fins pessoais, é considerado conflitante com os interesses organizacionais.";
                    break;
                case "conflito_interesses_transparencia":
                    responseMessage = "Os colaboradores devem adotar o princípio da transparência e reportar quaisquer negócios ou atividades externas que possam gerar conflito de interesses no Termo de Adesão ao Código de Ética.";
                    break;
                case "contratacao_parentes_criterios":
                    responseMessage = "A contratação de parentes segue critérios técnicos, justos e igualitários. Não será aceita quando houver subordinação direta ou na mesma diretoria em determinadas áreas.";
                    break;
                case "contratacao_parentes_union_estavel":
                    responseMessage = "Colaboradores em condição de noivado ou união estável com subordinados(as) devem ser transparentes e comunicar a situação ao gestor ou à Área de Recursos Humanos.";
                    break;
                case "contratacao_parentes_riscos":
                    responseMessage = "A contratação de profissionais em posição de liderança com parentes em empresas concorrentes, fornecedores, clientes ou prestadores de serviço deve ser informada para análise de riscos.";
                    break;
                case "indicacao_parentes":
                    responseMessage = "Ao indicar parentes para vagas, o colaborador deve informar a condição de parentesco e fornecer o currículo do candidato para a Área de Recursos Humanos.";
                    break;

                case "parentesco_por_consguinidade":
                    responseMessage = "São considerados parentes por consanguinidade: pai, mãe, filho, irmãos, avós, tios, sobrinhos, bisavós e primos.";
                    break;
                case "parentesco_por_afinidade":
                    responseMessage = "São considerados parentes por afinidade: cônjuge, sogro, sogra, genro, nora, cunhado, cunhada, concunhado, concunhada, padrasto, madrasta, enteado e enteada.";
                    break;
                case "troca_de_brindes_presentes_permitida":
                    responseMessage = "A oferta e aceitação de refeições ocasionais, ingressos para eventos esportivos, culturais ou científicos, itens promocionais e produtos consumíveis como caixa de chocolates são geralmente permitidos.";
                    break;
                case "troca_de_brindes_presentes_nao_permitida":
                    responseMessage = "Não é permitida a oferta ou aceitação de dinheiro, acessórios de luxo, equipamentos eletrônicos, viagens e serviços de hotelaria, ou presentes que impliquem algum tipo de acordo.";
                    break;
                case "valor_maximo_brindes_presentes":
                    responseMessage = "As trocas de gentilezas devem representar valores de até 1/3 de um salário mínimo vigente. Presentes que excedam esse valor devem ser comunicados à Área de Integridade Corporativa.";
                    break;
                case "presentes_pessoais_rejeicao":
                    responseMessage = "Recuse presentes ou convites que tragam a sensação de obrigação em retribuir ou que excedam o valor limite estabelecido. Se a recusa puder prejudicar negociações, converse com seu superior sobre a melhor forma de proceder.";
                    break;
                case "presentes_e_brindes_foras_do_trabalho":
                    responseMessage = "Nunca receba ou dê brindes ou presentes fora do ambiente de trabalho, nem aceite presentes em nome da empresa em sua residência.";
                    break;
                case "fraude_definicao":
                    responseMessage = "Fraude é caracterizada por atos enganosos ou de má-fé, como falsificação de documentos, contrabando, ou sonegação fiscal, e envolve desvio de conduta inaceitável.";
                    break;
                case "fraude_condutas_condenaveis":
                    responseMessage = "Condutas que caracterizam fraude incluem: passar-se por outra pessoa, alterar dados para benefício próprio, forçar subordinados a esconder informações, desviar recursos, e solicitar reembolso de despesas inexistentes.";
                    break;

                case "seguranca_informacoes":
                    responseMessage = "Manter em segurança e sigilo as informações de nossos clientes, colaboradores e do mercado está previsto em Política e Normas da empresa.";
                    break;
                case "acesso_informacoes_confidenciais":
                    responseMessage = "O acesso a informações consideradas confidenciais ou privilegiadas é restrito a lideranças. Informações estratégicas são disponibilizadas a colaboradores para o desempenho de suas atividades e não devem ser compartilhadas com colegas ou terceiros.";
                    break;
                case "manipulacao_informacoes":
                    responseMessage = "Reprovamos condutas de manipulação ou utilização de informações do Grupo Eurofarma e de seus públicos, sem autorização prévia ou visando benefícios pessoais.";
                    break;
                case "utilizacao_informacoes_concorrencia":
                    responseMessage = "Reprovamos a utilização de informações da concorrência de modo não lícito para gerar suposta vantagem ao Grupo Eurofarma, especialmente informações confidenciais obtidas em empregos anteriores.";
                    break;
                case "propriedade_intelectual":
                    responseMessage = "Ferir os princípios da propriedade intelectual, utilizando para fins pessoais ou repassando a terceiros, marcas, tecnologias, metodologias ou qualquer informação da companhia é um grave desvio de conduta.";
                    break;
                case "seguranca_privacidade_informacao":
                    responseMessage = "Todos devem observar as diretrizes estabelecidas na Política de Segurança e Privacidade da Informação do Grupo Eurofarma. É responsabilidade de cada um garantir a segurança da informação.";
                    break;
                case "compartilhamento_senhas":
                    responseMessage = "As senhas utilizadas na empresa são de caráter estritamente pessoal e intransferível. O compartilhamento de senhas configura desvio de conduta.";
                    break;
                case "acesso_informacoes_sem_autorizacao":
                    responseMessage = "Nenhum colaborador pode utilizar ou revelar informações confidenciais, internas ou estratégicas da empresa, exceto se devidamente autorizado. Solicite auxílio do seu gestor em caso de dúvida.";
                    break;
                case "armazenamento_informacoes":
                    responseMessage = "Não guarde informações do Grupo Eurofarma em dispositivos pessoais. Informações profissionais devem ser devolvidas à empresa e não guardadas em casa ou em outros locais.";
                    break;
                case "vazamento_informacoes":
                    responseMessage = "Adote medidas para evitar o vazamento de informações restritas. Documentos confidenciais não devem ficar expostos e computadores devem ser bloqueados quando ausentes.";
                    break;
                case "discussao_informacoes_sigilosas":
                    responseMessage = "Evite discutir assuntos sensíveis ou informações sigilosas em lugares públicos como elevadores, saguões, recepção, restaurante, banheiros ou transporte público.";
                    break;
                case "uso_patrimonio_empresa":
                    responseMessage = "Todos os ativos da empresa devem ser utilizados unicamente para os negócios do Grupo Eurofarma e não para benefício pessoal.";
                    break;
                case "recursos_tecnologicos":
                    responseMessage = "Os Recursos de Tecnologia da Informação do Grupo Eurofarma incluem equipamentos de informática e devem ser utilizados de acordo com as normas da empresa. O uso de softwares não autorizados é crime.";
                    break;
                case "uso_marca_empresa":
                    responseMessage = "A marca Grupo Eurofarma deve ser utilizada de acordo com o Manual de Identidade Visual e com autorização prévia da Área de Comunicação Corporativa.";
                    break;
                case "nepotismo":
                    responseMessage = "A prática do nepotismo é condenável. Gestores não devem utilizar sua posição para promover pessoas próximas sem qualificação e mérito.";
                    break;
                case "contratacao_ex_funcionarios":
                    responseMessage = "A contratação de ex-funcionários que tinham subordinação direta na antiga empresa não é permitida se tiver ocorrido há menos de dois anos, salvo exceções aprovadas pela área de Recursos Humanos.";
                    break;

                case "ambiente_trabalho":
                    responseMessage = "Comprometemo-nos a manter um ambiente de trabalho produtivo, saudável e profissional, respeitando leis e direitos dos colaboradores.";
                    break;
                case "respeito_direitos":
                    responseMessage = "Devemos cumprir as leis, convenções e acordos coletivos, respeitando os direitos dos colaboradores e garantindo uma relação de confiança e lealdade.";
                    break;
                case "saude_seguranca":
                    responseMessage = "Contribuir para um ambiente seguro e saudável, prevenindo doenças ocupacionais e acidentes de trabalho, é uma obrigação de todos nós.";
                    break;
                case "protege_informacoes":
                    responseMessage = "Proteger as informações e registros pessoais de colaboradores e prestadores de serviços é fundamental, mantendo-os restritos àqueles que precisam conhecê-los.";
                    break;
                case "responsabilidade_socioambiental":
                    responseMessage = "Estimular e promover ações de responsabilidade socioambiental é um compromisso da empresa.";
                    break;
                case "liberdade_associativa":
                    responseMessage = "Respeitamos o direito dos colaboradores de se associarem a sindicatos, entidades da sociedade civil, religiosas e partidos políticos.";
                    break;
                case "liberdade_expressao":
                    responseMessage = "Apoiar a liberdade de expressão e coibir qualquer tipo de ameaça, assédio ou intimidação é essencial para nosso ambiente de trabalho.";
                    break;
                case "lideranca_exemplo":
                    responseMessage = "Os gestores devem liderar pelo exemplo, promovendo um ambiente de trabalho que reflete os valores da empresa e estimulando o engajamento da equipe.";
                    break;
                case "desempenho_coletivo":
                    responseMessage = "A excelência no desempenho individual deve contribuir para o aprimoramento coletivo, estimulando o engajamento das equipes e recompensando os méritos.";
                    break;
                case "gestao_confianca":
                    responseMessage = "A gestão deve ser guiada pela confiança mútua, respeito e incentivo à inovação, promovendo um ambiente onde os colaboradores se sintam motivados a melhorar e propor novos processos.";
                    break;
                case "dialogo_colaboradores":
                    responseMessage = "O diálogo e o espaço para manifestação dos colaboradores devem prevalecer em todas as áreas, celebrando conquistas em grupo e estimulando o trabalho em equipe.";
                    break;
                case "representacao_equipe":
                    responseMessage = "Gestores devem representar adequadamente a equipe e a empresa, não sendo negligentes com suas atribuições e evitando a omissão de fatos que comprometem os princípios do Código.";
                    break;
                case "transparencia_recrutamento":
                    responseMessage = "A Área de Recursos Humanos deve assegurar a transparência e servir como canal de comunicação entre a Direção e os colaboradores.";
                    break;
                case "qualificacao_profissionais":
                    responseMessage = "Identificar necessidades de aperfeiçoamento e facilitar a participação em treinamentos é uma responsabilidade da Área de Recursos Humanos.";
                    break;
                case "qualidade_vida":
                    responseMessage = "Manter a qualidade de vida dos colaboradores e um ambiente de trabalho seguro e saudável é essencial para a Área de Recursos Humanos.";
                    break;
                case "gestao_carreira":
                    responseMessage = "Monitorar o desempenho dos profissionais e criar mecanismos para mantê-los motivados é uma função da Área de Recursos Humanos.";
                    break;
                case "gestao_cargos_salarios":
                    responseMessage = "Certificar-se de que a atribuição de cargos e remunerações está alinhada com o mercado e a Política Salarial da companhia é responsabilidade da Área de Recursos Humanos.";
                    break;
                case "adequacao_legal":
                    responseMessage = "A Área de Integridade Corporativa deve garantir que a empresa e seus colaboradores estejam em conformidade com leis e normas.";
                    break;
                case "principios_eticos":
                    responseMessage = "Assegurar a observância dos princípios éticos e normas de conduta descritos no Código de Ética é uma responsabilidade da Área de Integridade Corporativa.";
                    break;
                case "gestao_codigo_etica":
                    responseMessage = "Garantir a atualização do Código de Ética, fornecer treinamentos e suporte para decisões éticas é uma função da Área de Integridade Corporativa.";
                    break;
                case "politicas_normas_internas":
                    responseMessage = "A Área de Integridade Corporativa deve assegurar a implementação, aderência e atualização das políticas e normas internas.";
                    break;
                case "cultura_controles":
                    responseMessage = "Fomentar a cultura de controles internos em conformidade com os pilares do Sistema de Controles Internos é uma responsabilidade da Área de Integridade Corporativa.";
                    break;
                case "imparcialidade_transparencia":
                    responseMessage = "A análise de eventuais violações deve ser baseada em fatos reais e com o mais elevado conceito de justiça, evitando opiniões pessoais.";
                    break;
                case "auxilio_diretrizes":
                    responseMessage = "A Área de Integridade Corporativa deve servir como consultor permanente para todas as áreas e colaboradores, auxiliando na aplicação das diretrizes do Código de Ética.";
                    break;

                case "papel_agente_integridade_corporativa":
                    responseMessage = "Os Agentes de Integridade Corporativa são responsáveis por garantir o cumprimento das diretrizes do Código de Ética em cada Operação Internacional, reportando-se diretamente à área de Integridade Corporativa do Brasil e atuando como multiplicadores para a Comunicação Corporativa.";
                    break;
                case "papel_diretoria":
                    responseMessage = "A Diretoria deve promover uma cultura ética por meio de valores morais e liderança pelo exemplo, combatendo atitudes antiéticas e garantindo um ambiente de trabalho respeitoso e não autoritário.";
                    break;
                case "competicao_interna":
                    responseMessage = "A competição interna deve ser saudável e incentivar o trabalho em equipe, evitando a sonegação de informações, a recusa de ajuda a colegas e a apresentação de dados falsos.";
                    break;
                case "punicao_erro":
                    responseMessage = "Deve-se combater a punição de erros cometidos de boa-fé e punir apenas a omissão e a transferência de culpa.";
                    break;
                case "punicao_fracasso":
                    responseMessage = "O não cumprimento de metas deve ser analisado pela liderança, considerando resultados, causas e estratégias adotadas, e não apenas como fracasso.";
                    break;
                case "agressividade":
                    responseMessage = "Comportamentos agressivos e desrespeitosos são antiéticos e não devem ser permitidos no ambiente de trabalho.";
                    break;
                case "autoritarismo":
                    responseMessage = "A liderança deve promover um ambiente aberto e permitir o direito de discordar com base em princípios éticos, evitando o autoritarismo.";
                    break;
                case "imediatismo":
                    responseMessage = "A visão imediatista não deve prevalecer sobre os interesses de médio e longo prazos.";
                    break;
                case "vencer_custo":
                    responseMessage = "No Grupo Eurofarma, os fins não justificam os meios; a forma como as metas e objetivos são alcançados deve ser considerada.";
                    break;
                case "plano_metas":
                    responseMessage = "A negociação de metas é preferível à imposição; metas devem ser ambiciosas, mas factíveis, e não impostas para beneficiar gestores ou justificar demissões.";
                    break;
                case "transparencia":
                    responseMessage = "A transparência é um princípio inegociável e todos os líderes devem atuar com transparência com suas equipes e pares.";
                    break;
                case "conselho_comite_etica":
                    responseMessage = "O Conselho e o Comitê de Ética do Grupo Eurofarma são responsáveis por apoiar a aplicação do Código de Ética, assegurar a interpretação correta das diretrizes e analisar situações não previstas no Código.";
                    break;
                case "diretrizes_gerais":
                    responseMessage = "É esperado que todos os colaboradores exerçam a ética e o bom-senso, considerando a conformidade com os valores do Grupo Eurofarma e a legislação ao tomar decisões.";
                    break;
                case "responsabilidade_pessoal":
                    responseMessage = "Todos têm a responsabilidade de informar infrações ao Código de Ética, sendo a omissão repudiada. Informações podem ser feitas de forma anônima através do Canal de Ouvidoria.";
                    break;
                case "comunicacao_transparente":
                    responseMessage = "Líderes devem manter um ambiente que estimule a comunicação direta e transparente com suas equipes.";
                    break;

                case "relato_indicio_suspeita":
                    responseMessage = "Os colaboradores devem relatar qualquer indício ou suspeita de desvio do Código ao Diretor de sua Área ou à Área de Integridade Corporativa, através de e-mail, malote, telefone, ou pessoalmente.";
                    break;
                case "canal_ouvidoria":
                    responseMessage = "O Canal de Ouvidoria é uma ferramenta externa, independente e confidencial disponível 24 horas por dia para relatar comportamentos em desacordo com o Código de Ética, com atendimento em português e espanhol.";
                    break;
                case "situacoes_relatadas_ouvidoria":
                    responseMessage = "No Canal de Ouvidoria, podem ser relatados comportamentos ou suspeitas de atitude em desacordo com o Código de Ética relacionados a colaboradores, fornecedores, clientes e parceiros da empresa.";
                    break;
                case "motivo_denunciar":
                    responseMessage = "Denunciar é importante pois desvios de conduta podem afetar o ambiente organizacional, a motivação, a qualidade dos produtos e a imagem da instituição.";
                    break;
                case "quantidade_denuncias":
                    responseMessage = "Se for realizar uma denúncia sobre uma situação real ou potencial, faça-o apenas uma vez. Várias denúncias sobre a mesma ocorrência podem aumentar os custos e a demora na análise.";
                    break;
                case "denuncia_vs_denuncismo":
                    responseMessage = "Denúncia é o reporte de ato ilícito ou conduta moralmente inaceitável, enquanto denuncismo é o reporte falso ou infundado, geralmente motivado por tentativa de difamação ou vantagem pessoal.";
                    break;
                case "coibicao_retalizacao":
                    responseMessage = "O Grupo Eurofarma coíbe ações retaliatórias contra colaboradores que indicam preocupações legítimas ou questões referentes ao descumprimento do Código.";
                    break;
                case "cooperacao_apuracao":
                    responseMessage = "Todos devem cooperar com a apuração de denúncias de descumprimento ao Código quando necessário.";
                    break;
                case "denuncia_improrpria":
                    responseMessage = "Caso suspeite de uma possível violação de leis ou padrões éticos, informe ao seu gestor ou à Área de Integridade Corporativa imediatamente.";
                    break;
                default:
                    responseMessage = "Desculpe, não entendi sua solicitação. Por favor, tente novamente.";
                    break;
            }

            String responseJson = String.format("{\"fulfillmentText\": \"%s\"}", responseMessage);
            return ResponseEntity.ok(responseJson);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro interno do servidor.");
        }
    }
}
