import java.awt.Color;

public class MakeGraphsIREC {

    public static void rho(){
        TStyle.getInstance().getPalette().setColorScheme("bright10");
        H1F h122 = (H1F) TDirectory.loadData( "treefile_protonX2.twig", "studio/h122");
        List<String> text = new ArrayList<>();
        text.add("\u2022 AI/ML Track reconsturcion");
        text.add("\u2022 AI/ML Electron Identification");
        text.add("\u2022 Real-Time: 7kHz (8 Cores)");

        h122.attr().set("fc=3");
        h122.attr().setLegend("e(H) #rarrow e^'#pi^+#pi^-(p)");
        h122.attr().setTitleX("M(#pi^+#pi^-) [GeV]");
        PaveText pt = new PaveText("#rho(770 MeV)",0.28,0.84,false,18);
        PaveText pt2 = new PaveText(text,0.35,0.64,false,18);
        pt2.setTextColor(new Color(56, 102, 65));
        TGCanvas c = new TGCanvas("figure_irec_rho",550,500);
        c.draw(h122,"same");
        c.region().showLegend(0.52,0.98);
        c.region().draw(pt);
        c.region().draw(pt2);
        c.region().setAxisWidth(2);
        c.region().setAxisGrid(true,true);
    }

    public static void lambda(){
        TStyle.getInstance().getPalette().setColorScheme("bright10");
        H1F h122 = (H1F) TDirectory.loadData( "treefile_kaonX.twig", "studio/h120");
        List<String> text = new ArrayList<>();
        text.add("\u2022 AI/ML Track reconsturcion");
        text.add("\u2022 AI/ML Electron Identification");
        text.add("\u2022 Real-Time: 7kHz (8 Cores)");

        h122.attr().set("fc=5");
        h122.attr().setLegend("e(H) #rarrow e^'pK^-(K^+)");
        h122.attr().setTitleX("M(pK^-) [GeV]");
        PaveText pt = new PaveText("#Lambda(1520 MeV)",0.15,0.94,false,18);
        PaveText pt2 = new PaveText(text,0.35,0.84,false,18);
        pt2.setTextColor(new Color(56, 102, 65));
        TGCanvas c = new TGCanvas("figure_irec_lambda",550,500);
        c.draw(h122,"same");
        c.region().showLegend(0.52,0.98);
        c.region().draw(pt);
        c.region().draw(pt2);
        c.region().setAxisWidth(2);
        c.region().setAxisGrid(true,true);
    }
}