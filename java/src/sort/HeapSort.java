package sort;

import java.util.Arrays;

//������
/*
 * һ��������ô󶥶ѣ��������С����
 * 
 * 1.�����������й����һ���󶥶�
 2.��ʱ���������е����ֵ���ǶѶ��ĸ��ڵ㡣
 3.������ĩβԪ�ؽ��н�������ʱĩβ��Ϊ���ֵ��
 4.Ȼ��ʣ��n-1��Ԫ�����¹����һ���ѣ�������õ�n��Ԫ�صĴ�Сֵ����˷���ִ�У����ܵõ�һ�����������ˡ�

 ���Կ����ڹ����󶥶ѵĹ����У�Ԫ�صĸ����𽥼��٣����͵õ�һ������������.
�󶥶��ص㣺arr[i] >= arr[2*i+1] && arr[i] >= arr[2*i+2]  // i ��Ӧ�ڼ����ڵ㣬i��0��ʼ���7

С���ѣ�arr[i] <= arr[2*i+1] && arr[i] <= arr[2*i+2] // i ��Ӧ�ڼ����ڵ㣬i��0��ʼ���
 */
public class HeapSort {

	/**
	 * ����һ:�����ʼ�ѡ��������������й����һ���󶥶ѣ�һ��������ô󶥶ѣ��������С����)��ԭʼ������[4,6,8,5,9]
	 * �����:���Ѷ�Ԫ����ĩβԪ�ؽ��н�����ʹĩβԪ�����Ȼ����������ѣ��ٽ��Ѷ�Ԫ����ĩβԪ�ؽ���,�õ��ڶ���Ԫ�ء���˷������н������ؽ���������
	 * ������˼·�����ܽ�:
1.���������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����; 
2.���Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ��"��"������ĩ��; 
3.���µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�����ִ�е���+�������裬 ֱ��������������
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={4,6,8,5,9};
		heapSort(arr);
	}
	
	public static void heapSort(int[] arr){
		System.out.println("������");
		int temp=0;
		//1.���������й�����һ����,��������������ѡ��󶥶ѻ�С����
		for(int i=arr.length/2-1;i>=0;i--)
		{
			adjustHeap(arr, i, arr.length);
		}
		//2.���Ѷ�Ԫ����ĩβԪ�ؽ���,�����Ԫ��"��"������ĩ��;
		//3.���µ����ṹ,ʹ������Ѷ���,Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ��,����ִ�е���+��������,ֱ��������������
		for(int j=arr.length-1;j>0;j--)
		{
			temp=arr[j];
			arr[j]=arr[0];
			arr[0]=temp;
			adjustHeap(arr, 0, j);
		}
		System.out.println("�󶥶������"+Arrays.toString(arr));
	}
	/**
	 * ����: ��� �� �� i ��Ӧ�ķ�Ҷ�ӽ����������ɴ󶥶�
	 * 
	 * @param arr �����������
	 * @param i ��Ҷ�ӽڵ������
	 * @param length Ҫ������Ԫ�ظ���
	 */
	public static void adjustHeap(int[] arr,int i,int length){
		//�ѷ�Ҷ�ӽڵ��ֵ��������
		int temp=arr[i];
		//˵��:
		//1. j = i * 2 + 1 j �� i�������ӽ��
		for(int j=i*2+1;j<length;j=j*2+1)
		{
			//˵�����ӽڵ��ֵС�����ӽڵ��ֵ
			if(j+1<length&&arr[j]<arr[j+1])
			{
				j++;//jָ�����ӽڵ�
			}
			//����ӽڵ���ڸ��ڵ�
			if(arr[j]>temp)
			{
				arr[i]=arr[j];//���ϴ��ֵ������ǰ�Ľڵ�
				i=j;//��iָ��j������ѭ��
				
			}else{
				break;
			}
			// ��for ѭ��������,�Ѿ����� i Ϊ�������������ֵ,�������(�ֲ�)
			arr[i] = temp;
		}
		
	}

}