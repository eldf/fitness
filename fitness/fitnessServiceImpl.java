package fitness;



import java.util.LinkedList;
import java.util.List;





public class fitnessServiceImpl implements fitnessService {
	

		private List<fitness> fitnessList= new LinkedList<fitness>();
		
		
		public List<fitness> importar(String limite, String startdate, String enddate){
			List<fitness> result = new LinkedList<fitness>();
			wsfit ws= new wsfit();
			result=ws.procesar(limite, startdate,enddate);
			fitbd fitb = new fitbd();
			fitb.almacenar(result);
			
	
			
			return result;
		}
	

}
