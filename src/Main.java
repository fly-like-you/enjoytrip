import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.AttractionsDto;
import com.ssafy.attraction.service.AttractionService;
import com.ssafy.attraction.service.AttractionServiceImpl;
public class Main {
	
	static AttractionService attractionService = AttractionServiceImpl.getBoardService();
	public static void main(String[] args) {
	
		AttractionsDto list = attractionService.searchAttractionsAll();
		
		System.out.println("********** 글목록(전체) **********");
		for(AttractionDto attr : list.getAttractions()) {
			System.out.println(attr);
		}
	}
	
}
