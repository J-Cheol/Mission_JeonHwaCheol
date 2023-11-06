package com.ll;

import java.util.Scanner;

public class App
{
    public void run()
    {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
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
                scanner.nextLine();
                System.out.print("작가 : ");
                scanner.nextLine();
                System.out.println("1번 명언이 등록되었습니다.");
            }
        }
    }
}
