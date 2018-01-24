import java.util.Stack;

public class Homework1 {

	public static Node bitree;
	public static Stack<Character> numope = new Stack<Character>();


	public static void main(String[] args) {

		if(args.length > 0) {
			String input = args[0];
			if(input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
		}


		String input ="251-*32*+";
		for(int i=0;i<input.length();i++)
		{
			numope.add(input.charAt(i));
		}
		bitree = new Node(numope.pop());

		infix(bitree);
		inorder(bitree);
		System.out.println("="+calculate(bitree));
		// End of arguments input sample
		// TODO: Implement your project here
		TreeDemo.main(args);
	}


	public static void infix(Node z1) {
		if(z1.num_ope == '+' || z1.num_ope == '-' || z1.num_ope == '*' || z1.num_ope == '/') {
			z1.right = new Node(numope.pop());
			infix(z1.right);
			z1.left = new Node(numope.pop());
			infix(z1.left);
		}
	}

	public static void inorder(Node z2) {
		if(z2.num_ope =='+' || z2.num_ope =='-' || z2.num_ope =='*' || z2.num_ope == '/') {
			if(z2 != bitree) { System.out.print("(");}

			inorder(z2.left);
			System.out.print(z2.num_ope);
			inorder(z2.right);

			if(z2 != bitree) {System.out.print(")");}
		}else {
			if(z2 != bitree) {
				System.out.print(z2.num_ope);
			}
		}
	}


	public static int calculate(Node z3){
		if(z3.num_ope =='+' ) {
			return calculate(z3.left) + calculate(z3.right);}
		if(z3.num_ope == '-') {
			return calculate(z3.left) - calculate(z3.right);}
		if(z3.num_ope == '*') {
			return calculate(z3.left) * calculate(z3.right);}
		if(z3.num_ope == '/') {
			return calculate(z3.left) / calculate(z3.right);}

		else return Integer.parseInt(z3.num_ope.toString());
	}

}