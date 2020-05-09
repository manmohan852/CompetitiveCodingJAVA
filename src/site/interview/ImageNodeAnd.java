package site.interview;

public class ImageNodeAnd {

    public static class ImageNode{
        int value;
        ImageNode[] imageNodes;
        ImageNode(int value){
            this.value = value;
            this.imageNodes = null;
        }
    }

    public static ImageNode performAnd(ImageNode imageNode1,ImageNode imageNode2){
        ImageNode resultNode = new ImageNode(-1);
        if(imageNode1.value != -1 && imageNode2.value != -1){
            if(imageNode1.value == 1 && imageNode2.value == 1){
                resultNode.value = 1;
            }else {
                resultNode.value = 0;
            }
        }else if(imageNode1.value != -1 && imageNode2.value == -1){
            if(imageNode1.value == 1){
                resultNode = imageNode2;
            }else{
                resultNode.value = 0;
            }
        }else if(imageNode1.value == -1 && imageNode2.value != -1){
            if(imageNode2.value == 1){
                resultNode = imageNode1;
            }else{
                resultNode.value = 0;
            }
        }else{
            ImageNode[] imageNodes1 = imageNode1.imageNodes;
            ImageNode[] imageNodes2 = imageNode2.imageNodes;
            resultNode.imageNodes = new ImageNode[4];
            for (int i=0;i<4;i++){
                resultNode.imageNodes[i] = performAnd(imageNodes1[i],imageNodes2[i]);
            }
        }

        if(resultNode.imageNodes != null){
            if((resultNode.imageNodes[0].value == resultNode.imageNodes[1].value) &&
                    ( resultNode.imageNodes[1].value == resultNode.imageNodes[2].value) &&
                    (resultNode.imageNodes[2].value == resultNode.imageNodes[3].value)){
                return new ImageNode(resultNode.imageNodes[0].value);
            }
        }
        return resultNode;
    }

    public static void  printNode(ImageNode imageNode){
        System.out.println(imageNode.value);
        if(imageNode.imageNodes != null){
            for (int i =0;i<4;i++){
                if(imageNode.imageNodes[i].value != -1) {
                    System.out.print(imageNode.imageNodes[i].value);
                    System.out.print(" ");
                }else{
                    printNode(imageNode.imageNodes[i]);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {

        //case 1
        ImageNode imageNode1 = new ImageNode(0);
        ImageNode imageNode2 = new ImageNode(1);
        ImageNode res1 = performAnd(imageNode1,imageNode2);
        printNode(res1);

        //case 2
        ImageNode imageNode11 = new ImageNode(1);
        ImageNode imageNode22 = new ImageNode(1);
        ImageNode res2 = performAnd(imageNode11,imageNode22);
        printNode(res2);

        //case 3
        ImageNode imageNode12 = new ImageNode(0);
        ImageNode imageNode23 = new ImageNode(0);
        ImageNode res3 = performAnd(imageNode12,imageNode23);
        printNode(res3);


        //case 4
        ImageNode imageNode122 = new ImageNode(-1);
        imageNode122.imageNodes = new ImageNode[4];
        imageNode122.imageNodes[0] = new ImageNode(0);
        imageNode122.imageNodes[1] = new ImageNode(1);
        imageNode122.imageNodes[2] = new ImageNode(1);
        imageNode122.imageNodes[3] = new ImageNode(0);
        ImageNode imageNode232 = new ImageNode(0);
        ImageNode res4 = performAnd(imageNode122,imageNode232);
        printNode(res4);

        //case 5
        ImageNode imageNode5 = new ImageNode(-1);
        imageNode5.imageNodes = new ImageNode[4];
        imageNode5.imageNodes[0] = new ImageNode(0);
        imageNode5.imageNodes[1] = new ImageNode(1);
        imageNode5.imageNodes[2] = new ImageNode(1);
        imageNode5.imageNodes[3] = new ImageNode(0);
        ImageNode imageNode55 = new ImageNode(1);
        ImageNode res5 = performAnd(imageNode5,imageNode55);
        printNode(res5);


        //case 6
        ImageNode imageNode61 = new ImageNode(-1);
        imageNode61.imageNodes = new ImageNode[4];
        imageNode61.imageNodes[0] = new ImageNode(0);
        imageNode61.imageNodes[1] = new ImageNode(1);
        imageNode61.imageNodes[2] = new ImageNode(1);
        imageNode61.imageNodes[3] = new ImageNode(0);

        ImageNode imageNode62 = new ImageNode(-1);
        imageNode62.imageNodes = new ImageNode[4];
        imageNode62.imageNodes[0] = new ImageNode(0);
        imageNode62.imageNodes[1] = new ImageNode(1);
        imageNode62.imageNodes[2] = new ImageNode(1);
        imageNode62.imageNodes[3] = new ImageNode(0);
        ImageNode res6 = performAnd(imageNode61,imageNode62);
        printNode(res6);

        //case 7
        ImageNode imageNode71 = new ImageNode(-1);
        imageNode71.imageNodes = new ImageNode[4];
        imageNode71.imageNodes[0] = new ImageNode(0);
        imageNode71.imageNodes[2] = new ImageNode(1);
        imageNode71.imageNodes[3] = new ImageNode(0);

        ImageNode imageNode711 = new ImageNode(-1);
        imageNode711.imageNodes = new ImageNode[4];
        imageNode711.imageNodes[0] = new ImageNode(0);
        imageNode711.imageNodes[1] = new ImageNode(1);
        imageNode711.imageNodes[2] = new ImageNode(1);
        imageNode711.imageNodes[3] = new ImageNode(0);

        imageNode71.imageNodes[1] = imageNode711;

        ImageNode imageNode72 = new ImageNode(-1);
        imageNode72.imageNodes = new ImageNode[4];
        imageNode72.imageNodes[0] = new ImageNode(0);
        imageNode72.imageNodes[1] = new ImageNode(1);
        imageNode72.imageNodes[2] = new ImageNode(1);
        imageNode72.imageNodes[3] = new ImageNode(0);

        ImageNode res7 = performAnd(imageNode71,imageNode72);
        printNode(res7);

        //case 8
        ImageNode imageNode81 = new ImageNode(-1);
        imageNode81.imageNodes = new ImageNode[4];
        imageNode81.imageNodes[0] = new ImageNode(1);
        imageNode81.imageNodes[2] = new ImageNode(1);
        imageNode81.imageNodes[3] = new ImageNode(1);

        ImageNode imageNode811 = new ImageNode(-1);
        imageNode811.imageNodes = new ImageNode[4];
        imageNode811.imageNodes[0] = new ImageNode(1);
        imageNode811.imageNodes[1] = new ImageNode(1);
        imageNode811.imageNodes[2] = new ImageNode(1);
        imageNode811.imageNodes[3] = new ImageNode(1);

        imageNode81.imageNodes[1] = imageNode811;

        ImageNode imageNode82 = new ImageNode(-1);
        imageNode82.imageNodes = new ImageNode[4];
        imageNode82.imageNodes[0] = new ImageNode(1);
        imageNode82.imageNodes[2] = new ImageNode(1);
        imageNode82.imageNodes[3] = new ImageNode(1);

        ImageNode imageNode822 = new ImageNode(-1);
        imageNode822.imageNodes = new ImageNode[4];
        imageNode822.imageNodes[0] = new ImageNode(1);
        imageNode822.imageNodes[1] = new ImageNode(1);
        imageNode822.imageNodes[2] = new ImageNode(1);
        imageNode822.imageNodes[3] = new ImageNode(1);

        imageNode82.imageNodes[1] = imageNode822;

        ImageNode res8 = performAnd(imageNode81,imageNode82);
        printNode(res8);

    }
}