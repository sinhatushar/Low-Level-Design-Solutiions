import Repository.BidRepository;
import Repository.PlayerRepository;
import Repository.TeamRepository;
import model.*;
import service.AuctionService;
import service.BidService;
import service.PlayerService;
import service.TeamService;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
        TeamRepository teamRepository = new TeamRepository();
        PlayerRepository playerRepository = new PlayerRepository();
        BidRepository bidRepository = new BidRepository();

        PlayerService playerService = new PlayerService(playerRepository);
        TeamService teamService = new TeamService(teamRepository);
        BidService bidService = new BidService(teamRepository, playerRepository, bidRepository);
        AuctionService auctionService = new AuctionService();

        Driver driver = new Driver();

        Player virat = playerService.addPlayer("Virat", 200, PlayerNationality.NATIVE, PlayerType.BATSMAN) ;
        Player rohit = playerService.addPlayer("Rohit", 150, PlayerNationality.NATIVE, PlayerType.BATSMAN) ;
        Player rahul = playerService.addPlayer("Rahul", 200, PlayerNationality.NATIVE, PlayerType.WICKET_KEEPER);

        Team rcb = teamService.addTeam("RCB", 1500);
        Team csk = teamService.addTeam("CSK", 3500);

        //////////////////////////
//        auctionService.startAuction(virat);
//
////        Integer currentMaxBid = 0;
//        Bid cskBid = bidService.addBid("CSK", "Virat", 350);
//        Bid rcbBid = bidService.addBid("RCB", "Virat", 400);
//
//        auctionService.placeBid(cskBid);
//        auctionService.placeBid(rcbBid);
//
//        Team winningTeam = auctionService.closeAuction();
//
//        driver.printPlayerOveview(playerService);
//        driver.printTeamOverview(teamService);
        //////////////////////////

        //////////////////////////
        AuctionService auctionService2 = new AuctionService();
        auctionService2.startAuction(rahul);

        Bid cskBid = bidService.addBid("CSK", "Rahul", 550);
        Bid rcbBid = bidService.addBid("RCB", "Rahul", 450);

        auctionService2.placeBid(cskBid);
        auctionService2.placeBid(rcbBid);

        Team winningTeam = auctionService2.closeAuction();

//        driver.printPlayerOveview(playerService);
//        driver.printTeamOverview(teamService);

        //////////////////////////

        ////////////////////////
        AuctionService auctionService1 = new AuctionService();
        auctionService1.startAuction(rohit);

        cskBid = bidService.addBid("CSK", "Rohit", 350);
        rcbBid = bidService.addBid("RCB", "Rohit", 250);

        auctionService1.placeBid(cskBid);
        auctionService1.placeBid(rcbBid);

        winningTeam = auctionService1.closeAuction();

        System.out.println("////////////////////////////////");
        List<Bid> bidsRahul = playerService.getAllBidsForPlayer("Rahul");

        for(var bid: bidsRahul){
            System.out.println(bid.getPlayer().getName() + " " + bid.getTeam().getName() + " " + bid.getBidAmount()) ;
        }

        List<Bid> bidsRohit = playerService.getAllBidsForPlayer("Rohit");

        for(var bid: bidsRohit){
            System.out.println(bid.getPlayer().getName() + " " + bid.getTeam().getName() + " " + bid.getBidAmount()) ;
        }

        List<Bid> bidsCsk = teamService.getAllBidsByTeam("CSK");
        List<Bid> bidsRcb = teamService.getAllBidsByTeam("RCB");

        for(var bid: bidsCsk){
            System.out.println(bid.getTeam().getName() + " " + bid.getPlayer().getName()) ;
        }

        for(var bid: bidsRcb){
            System.out.println(bid.getTeam().getName() + " " + bid.getPlayer().getName()) ;
        }
    }

    void printPlayerOveview(PlayerService playerService){
        //“Virat”, 	“SOLD”, “RCB”, 300
        List<Player> playerList = playerService.playerOverview();
        for(Player player: playerList){
            System.out.println(player.getName() + " " + player.getPlayerStatus() + " " + player.getTeam() + " " + player.getSellingPrice());
        }
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
    }

    void printTeamOverview(TeamService teamService){
        List<Team> teamList = teamService.teamOverview();
        for(Team team: teamList){
            System.out.println(team.getName());
            List<Player> purchasedPlayers = team.getPurchasedPlayers();
            for(Player player: purchasedPlayers){
                System.out.println(player.getName());
            }
            System.out.println(team.getWalletAmount());
        }
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
    }
}
