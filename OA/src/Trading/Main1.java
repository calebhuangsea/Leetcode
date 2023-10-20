package Trading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main1 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        TradeAggregator agg = new TradeAggregator();
        while ((line = in.readLine()) != null) {
            String[] tokens = line.split(" ");
            String command = tokens[0];

            if (command.equalsIgnoreCase("Trade"))
            {
                agg.HandleTrade(ParseTrade(tokens));

            }
            else
            {
                agg.HandleTheoUpdate(ParseTheoUpdate(tokens));
            }
        }
    }

    static class Trade
    {
        public Trade(String trader, int asset, int quantity, double price)
        {
            Trader = trader;
            Asset = asset;
            Quantity = quantity;
            Price = price;
        }
        public String Trader;
        public int Asset;
        public int Quantity;
        public double Price;
    };

    public static Trade ParseTrade(String[] tokens)
    {
        String trader = tokens[1];
        int asset = Integer.parseInt(tokens[2]);
        int quantity = Integer.parseInt(tokens[3]);
        double price = Double.parseDouble(tokens[4]);
        return new Trade(trader, asset, quantity, price);
    }

    static class TheoUpdate
    {
        public TheoUpdate(int asset, double value)
        {
            Asset = asset;
            Value = value;
        }
        public int Asset;
        public double Value;
    };

    public static TheoUpdate ParseTheoUpdate(String[] tokens)
    {
        int asset = Integer.parseInt(tokens[1]);
        double value = Double.parseDouble(tokens[2]);
        return new TheoUpdate(asset, value);
    }

    static class TradeAggregator
    {
        private Map<Integer, Double> assets;
        private Map<String, Double> traders;
        double max;

        public TradeAggregator()
        {
            assets = new HashMap<>();
            traders = new TreeMap<>();
            max = 0;
        }

        // public Trade(String trader, int asset, int quantity, double price)

        public void HandleTrade(Trade trade)
        {
            // update trader
            double diff = assets.get(trade.Asset) - trade.Price;
            double edge = diff * diff * Math.abs(trade.Quantity);
            traders.put(trade.Trader, traders.getOrDefault(trade.Trader, 0.0) + edge);
            max = Math.max(max, traders.get(trade.Trader));
            for (String key : traders.keySet()) {
                if (traders.get(key) == max) {
                    PrintTraderScore(key, traders.get(key));
                    break;
                }
            }
        }

        // public TheoUpdate(int asset, double value)
        public void HandleTheoUpdate(TheoUpdate theoUpdate)
        {
            assets.put(theoUpdate.Asset, theoUpdate.Value);
        }

        public void PrintTraderScore(String traderName, double score)
        {
            System.out.printf(traderName + " %.2f\n", score);
        }

    };

}

