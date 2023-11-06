package com.ll;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    Scanner scanner = new Scanner(System.in);
    List<Quotation> quotations = new ArrayList<>();
    int id = 0;

    App()
    {
        scanner = new Scanner(System.in);
        id = 0;
        quotations = new ArrayList<>();
    }

    public void run()
    {
        System.out.println("== 명언 앱 ==");
        while (true)
        {
            System.out.print("명령) ");
            String cmd = scanner.next();
            if (cmd.equalsIgnoreCase("종료"))
            {
                return;
            } else if (cmd.equalsIgnoreCase("등록"))
            {
                action_registration();
            } else if (cmd.equalsIgnoreCase("목록"))
            {
                action_list();
            } else if (cmd.startsWith("삭제?id="))
            {
                action_delete(cmd);
            } else if (cmd.startsWith("수정?id="))
            {
                action_edit(cmd);
            }
        }
    }

    void action_registration()
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

    void action_list()
    {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = quotations.size() - 1; i >= 0; i--)
        {
            Quotation quotation = quotations.get(i);
            if (quotations.get(i).author != null || quotations.get(i).catalog != null)
                System.out.printf("%d / %s / %s\n", quotation.id, quotation.author, quotation.catalog);
        }
    }

    void action_delete(String cmd)
    {
//        String[] parts = cmd.split("\\?");
//        String find_del = parts[1];
//        String[] find_del_part = find_del.split("=");
        int find_del_id = get_id(cmd);
        try
        {
            int del_id = find_del_id;
            if (del_id > 0 && del_id <= quotations.size())
            {
                Quotation check = quotations.get(del_id - 1);
                if (del_id == check.id && quotations.get(del_id - 1).author != null)
                {
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", del_id);
                    quotations.get(del_id - 1).id = del_id;
                    quotations.get(del_id - 1).author = null;
                    quotations.get(del_id - 1).catalog = null;
                } else
                {
                    System.out.printf("%d번 명언이 존재하지 않습니다.\n", del_id);
                }
            }
        } catch (NumberFormatException e)
        {
        }
    }

    void action_edit(String cmd)
    {
//        String[] parts = cmd.split("\\?");
//        String find_edit = parts[1];
//        String[] find_edit_part = find_edit.split("=");
        try
        {
            int edit_id = get_id(cmd);
            if (edit_id > 0 && edit_id <= quotations.size())
            {
                System.out.println("명언(기존) : " + quotations.get(edit_id - 1).catalog);
                scanner.nextLine();
                System.out.print("명언 : ");
                quotations.get(edit_id - 1).catalog = scanner.nextLine();
                System.out.println("작가(기존) : " + quotations.get(edit_id - 1).author);
                System.out.print("작가 : ");
                quotations.get(edit_id - 1).author = scanner.nextLine();
            }
        } catch (NumberFormatException e)
        {
        }
    }
    int get_id(String cmd)
    {
        String[] parts = cmd.split("\\?");
        String find_id_part = parts[1];
        String[] find_id = find_id_part.split("=");
        int id = Integer.parseInt(find_id[1]);
        return id;
    }
}


