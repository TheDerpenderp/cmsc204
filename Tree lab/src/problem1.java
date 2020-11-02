
public class problem1 {

	public static void main(String[] args) {
		int[] tree = {45,38,65,34,41,63,72,16,35,39,44,55,64};
		System.out.print("inorder: ");
		inOrder(tree, 0);
		System.out.println();
		System.out.print("preorder: ");
		preOrder(tree, 0);
		System.out.println();
		System.out.print("postorder: ");
		postOrder(tree, 0);

	}
	public static void inOrder(int[] tree, int index) {
		if(index>=tree.length) {
			return;
		}
		inOrder(tree, 2*index+1);
		System.out.print(tree[index]+", ");
		inOrder(tree, 2*index+2);
		
		
	}
	public static void postOrder(int[] tree, int index) {
		if(index>=tree.length) {
			return;
		}
		postOrder(tree, 2*index+2);
		System.out.print(tree[index]+", ");
		postOrder(tree, 2*index+1);
		
		
	}
	public static void preOrder(int[] tree, int index) {
		if(index>=tree.length) {
			return;
		}
		System.out.print(tree[index]+", ");
		preOrder(tree, 2*index+2);
		preOrder(tree, 2*index+1);
		
		
	}

}
