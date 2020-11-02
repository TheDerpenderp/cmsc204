
public class problem2 {

	public static void main(String[] args) {
		String[] tree = {"*","/","+","-","24","-","12","48","%",null,null,"18","*",null,null,null,null,"7","2",null,null,"5","2"};
		System.out.print("inorder: ");
		inOrder(tree, 0);


		System.out.println();
		System.out.print("postorder: ");
		postOrder(tree, 0);
		System.out.println();
		System.out.println(48-7%2/24*18-5*2+12
);

	}
	public static void inOrder(String[] tree, int index) {
		if((index>=tree.length)||(tree[index] == null)) {
			return;
		}
		inOrder(tree, 2*index+1);
		System.out.print(tree[index]+", ");
		inOrder(tree, 2*index+2);


	}
	public static void postOrder(String[] tree, int index) {
		if((index>=tree.length)||(tree[index] == null)) {
			return;
		}
		postOrder(tree, 2*index+2);
		System.out.print(tree[index]+", ");
		postOrder(tree, 2*index+1);


	}


}

