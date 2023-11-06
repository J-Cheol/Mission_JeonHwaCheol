package com.ll;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public void run()
    {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        List <Quotation> quotations = new ArrayList<>();
        int id = 0;
        while (true)
        {
            System.out.print("명령) ");
            String cmd = scanner.next();
            if (cmd.equalsIgnoreCase("종료"))
                return;
            if (cmd.equalsIgnoreCase("등록"))
            {
                scanner.nextLine();
                System.out.print("명언 : ");
                String quote = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                id++;
                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                Quotation quotation = new Quotation(id, author, quote);
                quotations.add(quotation);
            }
            if (cmd.equalsIgnoreCase("목록"))
            {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = quotations.size() - 1; i >= 0; i--)
                {
                    Quotation quotation = quotations.get(i);
                    System.out.printf("%d / %s / %s\n", quotation.id, quotation.author, quotation.catalog);
                }
            }
        }
    }
}
