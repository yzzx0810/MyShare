/*��Ŀ����
��ʦ��֪����ĳĳͬѧ���У�������ߵ��Ƕ��٣�����������ģ����ʦ��ѯ�ʡ���Ȼ����ʦ��ʱ����Ҫ����ĳλͬѧ�ĳɼ�. 
��������:
�����������������ݡ�
ÿ�������һ��������������N��M��0 < N <= 30000,0 < M < 5000��,�ֱ����ѧ������Ŀ�Ͳ�������Ŀ��
ѧ��ID��Ŵ�1�ൽN��
�ڶ��а���N��������������N��ѧ���ĳ�ʼ�ɼ������е�i��������IDΪi��ѧ���ĳɼ�
��������M�У�ÿһ����һ���ַ�C��ֻȡ��Q����U������������������A,B,��CΪ'Q'��ʱ��, ��ʾ����һ��ѯ�ʲ�������ѯ��ID��A��B������A,B����ѧ�����У��ɼ���ߵ��Ƕ���
��CΪ��U����ʱ�򣬱�ʾ����һ�����²�����Ҫ���IDΪA��ѧ���ĳɼ�����ΪB��


�������:
����ÿһ��ѯ�ʲ�������һ�����������߳ɼ�.

��������:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

�������:
5
6
5
9*/
package com.usst.share;

import java.util.*;

public class D {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		try {
			String l1 = in.nextLine();//��һ�У�N M��
			String l2 = in.nextLine();//�ڶ���
			String[] score = l2.split(" ");//�ɼ�����--N��
			int height = Integer.parseInt(l1.split(" ")[1]);
			ArrayList<String> operList = new ArrayList<>();
			//����Mֵ��ȷ�������������
			for(int i = 0; i < height; i++){
				operList.add(in.nextLine());
			}
			//����ִ�и�����
			for(int i =0; i < operList.size(); i++){
				String[] oper = operList.get(i).split(" ");
				switch (oper[0]) {
				case "Q":
					String[] result = new String[Integer.parseInt(oper[2])-Integer.parseInt(oper[1])+1];
					int start = Integer.parseInt(oper[1]);
					int end = Integer.parseInt(oper[2]);
					//��ѯ��ʼ��ĩβ������Խ��
					if( start>0 && end<=Integer.parseInt(l1.split(" ")[0]) && start<=end){
						int n = 0;
						for(int m = start-1; m<end; m++){
							result[n++] = score[m];
						}
						//һ��ð��������Сֵ�ƶ������һλ
						for(int k=0; k<result.length-1; k++){
							if(Integer.parseInt(result[k])< Integer.parseInt(result[k+1])){
								String str = result[k];
								result[k] = result[k+1];
								result[k+1] = str;
							}
						}
						System.out.println("��ʱ��СֵΪ��" + result[result.length-1]);
					}else{
						System.out.println("��ѯʧ��");
					}
					break;
				case "U":
					int obj = Integer.parseInt(oper[1]);
					//���µ�ַ����Խ��
					if(obj>0 && obj<=Integer.parseInt(l1.split(" ")[0])){
						score[obj-1] = oper[2];
					}else{
						System.out.println("���¶��󲻴��ڣ�����ʧ��");
					}
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			
		}finally {
			//��ʾ�ر�������
			in.close();
		}
	}
}
