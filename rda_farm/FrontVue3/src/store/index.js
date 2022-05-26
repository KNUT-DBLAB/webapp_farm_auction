import { createStore } from "vuex";
import { login } from "@/store/modules/login";
import { test } from "@/store/modules/test";
import { signup } from "@/store/modules/signup";
import axios from "axios"

export default createStore({
  modules: { 
    signup: signup,
    login: login,
    test: test,
  },
  state: {
    existEmail: true,
    kindOfFarm: null,
    user: {
        name: null,
        email: null,
        passwd: null,
        phonenum: null,
    },
    config: {
      headers: {
          TOKEN: null,
      }
    },
    auctionList: [],
    limit: 0,
  },
  mutations: {
      KIND_OF_FARM: (state, payload) => {
        console.log(payload);
        state.kindOfFarm = payload
      },
      FARM_INFO: (state, payload) => {
        console.log(payload);
        state.user = payload
      },
      EXIST_EMAIL: (state, existEmail) => {
        state.existEmail = existEmail
        console.log(state.existEmai);
      },
      TOKEN_SAVE: (state, token) => {
        console.log("TOKEN_SAVE: "+ token);
        state.config.headers.TOKEN = token;
        console.log(state.config);
      },
      PUSH_AUCTION: (state, auction) => {
        console.log(auction);
        state.auctionList.push(auction);
      },
      RESET_AUCTIONLIST: (state) => {
        state.auctionList = [];
      },
      UP_LIMIT: (state, addNum) => {
        console.log(addNum);
        state.limit += addNum;
      },
      RESET_LIMIT: (state) => {
        state.limit = 0;
      },
      UPDATE_BID_PRICE: (state, response_bidding) => {
        console.log("UPDATE_BID_PRICE");
        console.log(response_bidding);

        for (let i = 0; i < state.auctionList.length; i++) {
          if(response_bidding.auction_id == state.auctionList[i].auction_Id){
            console.log(state.auctionList[i].auction_Id);
            console.log(response_bidding.auction_id);

            state.auctionList[i].bid_price = response_bidding.bid_price
            break;
          }
        }
      }
  },
  actions: {
      existEmail: ({commit}, email) => {
          console.log(email);
          axios.get('http://localhost:8080/api/existEmail', {params: { email: email} })
          .then(res => {
            console.log(res);
            commit('EXIST_EMAIL', res.data == 1)
            if ( res.data == 1){
              alert("이미 존재하는 아이디입니다!")
            } else { 
              alert("사용 가능한 아이디입니다!")
            }
          })
          .catch(err => {
          console.log(err);
        });
      },
  }
});

