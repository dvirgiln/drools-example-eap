package org.drools.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsServlet extends HttpServlet {

    private final static Integer EMISOR_DEFAULT = 5;
    KieContainer kc;

    @Override
    public void init() {
        kc = KieServices.Factory.get().newKieClasspathContainer();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Start servlet");
        KieSession ksession = kc.newKieSession("rules-container");

        // KnowledgeRuntimeLogger logger =
        // KnowledgeRuntimeLoggerFactory.newFileLogger(ksession,
        // "log/fibonacci.log");

        DecisionParameter decisionParameter = new DecisionParameter();
        decisionParameter.setEmisor(EMISOR_DEFAULT);
        decisionParameter.setMonto(100L);

        ksession.insert(decisionParameter);
        ksession.insert(createSamManager(1L, 500L, 0));
        ksession.insert(createSamManager(2L, 750L, 0));
        ksession.insert(createSamManager(3L, 1000L, 0));
        ksession.fireAllRules();
        System.out.println(ksession.getGlobals());
        // logger.close();
        ksession.dispose(); // Stateful rule session must always be disposed
                            // when finished
        System.out.println("end servlet");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello Servlet Get</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    private SamManager createSamManager(Long id, Long amount, Integer operations) {
        SamManager samMgr = new SamManager();
        samMgr.setId(id);
        samMgr.setOperations(operations);
        samMgr.addEmisor(EMISOR_DEFAULT, amount);
        return samMgr;
    }
}