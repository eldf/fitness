package fitness;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;




public class FitnessViewModel {
	
	public String getLimite() {
		return limite;
	}


	public void setLimite(String limite) {
		this.limite = limite;
	}


	private String limite;
	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	private String startdate;
	private String enddate;
	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	private List<fitness> fitnessList;
	private fitnessService fitService = new fitnessServiceImpl();
	
	
	public List<fitness> getFitnessList() {
		return fitnessList;
	}


	public void setFitnessList(List<fitness> fitnessList) {
		this.fitnessList = fitnessList;
	}


	public fitnessService getFitService() {
		return fitService;
	}


	public void setFitService(fitnessService fitService) {
		this.fitService = fitService;
	}


	@Command
	@NotifyChange("fitList")
	public void importar(){
		fitnessList = fitService.importar(limite, startdate,enddate);
		System.out.println(fitnessList.size());
		System.out.println(fitnessList.get(0).getActivity_category());
		
	}

}
