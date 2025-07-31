public class MakeGraphs {

    public static void denoising(){
        TStyle.getInstance().getPalette().setColorScheme("bright10");
        H1F h304 = (H1F) TDirectory.loadData( "denosing_3particles.twig", "studio/h304");
        H1F h301 = (H1F) TDirectory.loadData( "denosing_3particles.twig", "studio/h301");
        h301.attr().set("fc=3");
        h304.attr().set("fc=4");
        h301.attr().setLegend("Conventional Tracking");
        h304.attr().setLegend("AI/ML Assisted Tracking");
        h304.attr().setTitleX("Mx (e^'#pi^+#pi^-) [GeV]");
        PaveText pt = new PaveText("e(H)#rarrowe^'#pi^+#pi^-",0.01,0.98);
        TGCanvas c = new TGCanvas("figure_dn_miss_p",550,500);
        c.draw(h304).draw(h301,"same");
        c.region().showLegend(0.38,0.98);
        c.region().draw(pt);
    }

    public static void lumi(){
        TStyle.getInstance().getPalette().setColorScheme("bright10");
        Graph gcv = new Graph("gconv",new double[]{5,15,30,50},new double[]{0.943,0.896,0.825,0.744});
	    Graph gai = new Graph("gconv",new double[]{5,15,30,50},new double[]{0.989,0.965,0.939,0.889});
        F1D   fscv = new F1D("fs","[a]+[b]*x",-0.1,60);
    	F1D   fkai = new F1D("fk","[a]+[b]*x",-0.1,60);
        
        gcv.attr().set("mc=3,ms=16,mo=1,mw=2");
        gai.attr().set("mc=4,ms=16,mt=3,mo=1,mw=2");
        fscv.attr().set("lc=3,ls=3,lw=4");
        fkai.attr().set("lc=4,ls=3,lw=4");
        fscv.fit(gcv);
	    fkai.fit(gai);
        fscv.attr().setTitleX("Beam Current [nA]");
        fscv.attr().setTitleY("Track Efficiency");
        String legend_cv = String.format("conventional (slope = %.6f)",fscv.getParameter(1));
        String legend_ai = String.format("denoised/ai-assisted (slope = %.6f)",fkai.getParameter(1));
        
        gcv.attr().setLegend(legend_cv);
        gai.attr().setLegend(legend_ai);
        
        TGCanvas c = new TGCanvas("figure_dn_lumi",550,500);
        c.draw(fscv,"same").draw(fkai,"same");
        c.draw(gcv,"Psame").draw(gai,"Psame");
        
        Legend leg = c.region().getLegend(2,3);
        //leg.remove(0);
        leg.setPosition(0.02,0.25);
        c.region().draw(leg);
        c.region().axisLimitsY(0.61,1.1);
        c.region().setAxisWidth(2);
        c.region().setAxisGrid(true,true);
    }
}