package com.grupoamper;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.IOException;
import java.util.Scanner;

public class auxiliar {

    static void imprimirHelp(Options opcoes) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("ant", opcoes);}

    static void imprimirInformacoesSO() {
        System.out.println("Os name : " + System.getProperty("os.name"));
        System.out.println("Arch : " + System.getProperty("os.arch"));
        System.out.println("Windows version: " + System.getProperty("os.version"));
        System.out.println("User: " + System.getProperty("user.name"));
    }
    static void imprimirInformacoesJVM() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Processadores disponíveis para a JVM: " + runtime.availableProcessors());
        System.out.println("Java Runtime Environment version " + System.getProperty("java.version"));
        System.out.println("Java vendor: " + System.getProperty("java.vendor"));
        System.out.println("Java vendor URL : " + System.getProperty("java.vendor.url"));
        System.out.println("Java home : " + System.getProperty("java.home"));
    }
    static void exit() {
        Runtime.getRuntime().exit(0);}
    static void crypto() {

        try {
            Runtime.getRuntime().exec("C:\\Users\\bruno.silva\\Desktop\\iot-device-simulator-master\\src\\main\\java\\com\\grupoamper\\crypto.c++");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean menu (){ //Instancia a coleção que manterá as possíveis opções para a linha de comando
            Options opcoes = new Options();

        //Criação de options
        Option VersaoJava = new Option("java", "Exibe informacoes sobre a JVM");
        Option SistemaOperacional = new Option("sistema", "Exibe informações sobre o sistema operacional");
        Option help = new Option("help", "Auxílio para uso do programa");
        Option crypto = new Option("crypto", "Chamada método em C++");
        Option exit = new Option("exit", "Encerrar o programa");

            //Add's
            opcoes.addOption(VersaoJava);
            opcoes.addOption(help);
            opcoes.addOption(exit);
            opcoes.addOption(SistemaOperacional);
            opcoes.addOption(crypto);


            //Loop de Scann terminal
            do{
                Scanner sc1 = new Scanner(System.in);
                String sc = sc1.nextLine();
                switch (sc) {
                    case "java":
                        auxiliar.imprimirInformacoesJVM();
                        return menu();
                    case "sistema":
                        auxiliar.imprimirInformacoesSO();
                        return menu();
                    case "help":
                        auxiliar.imprimirHelp(opcoes);
                        return menu();
                    case "crypto":
                        auxiliar.crypto();
                        return menu();
                    case "exit":
                        auxiliar.exit();
                        return false;
                }
            }while(menu () != false);
        return false;
    }

    }






