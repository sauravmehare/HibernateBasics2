import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		//FILL YOUR CODE
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log",
		"org.apache.commons.logging.impl.NoOpLog");
		ItemDAO dao=new ItemDAO();
		while(true) {
			System.out.println("Menu\r\n"+"1.Change item\r\n"+"2.Display items\r\n"+"3.Exit\r\n"+"Enter choice");
//			System.out.println("1.Change item");
//			System.out.println("2.Display items");
//			System.out.println("3.Exit");
//			System.out.println("Enter choice");
			switch(Integer.parseInt(br.readLine())) {
			case 1:
				System.out.println("Enter item id");
				Integer id=Integer.parseInt(br.readLine());
				Item item=dao.findItem(id);
				if(item==null) {
					System.out.println("Item not found");
				}
				else {
					System.out.println("Enter name");
					String name=br.readLine();
					System.out.println("Enter category");
					String category=br.readLine();
					System.out.println("Enter quantity");
					Integer quantity=Integer.parseInt(br.readLine());
					System.out.println("Enter price");
					Float price=Float.parseFloat(br.readLine());
					Item itemUpdate=new Item(id,name,category,quantity,price);
					dao.update(itemUpdate);
					System.out.println("Changes are updated successfully");	
				}
				break;
				
			case 2:
				System.out.printf("%-15s %-15s %-15s %-15s %s\n","Id","Name","Category","Quantity","Price");
				List<Item> list=dao.list();
				for(Item item3:list) {
					System.out.printf("%-15s %-15s %-15s %-15s %s\n",item3.getId(),item3.getName(),item3.getCategory(),item3.getQuantity(),item3.getPrice());
				}
				break;
				
			case 3:
				System.out.println("Bye");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid choice");
				
				
				
			}
			
		}
		
	}
}
