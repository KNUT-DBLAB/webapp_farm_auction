"use strict";(self["webpackChunkfront"]=self["webpackChunkfront"]||[]).push([[164],{164:function(e,n,l){l.r(n),l.d(n,{default:function(){return d}});var s=l(3396),a=l(9242);const o=(0,s._)("header",{class:"welcome-header"},[(0,s._)("h1",{class:"welcome-header__title"},"회 원 가 입")],-1),t={id:"signup"},i=(0,s._)("input",{class:"login-form__input",type:"password",name:"passwordcheck",id:"passwordcheck",required:"",placeholder:"비밀번호확인",minlength:"6"},null,-1);function r(e,n,l,r,u,m){return(0,s.wg)(),(0,s.iD)("div",null,[o,(0,s._)("div",t,[(0,s._)("form",{onSubmit:n[6]||(n[6]=(0,a.iM)(((...n)=>e.SignupForm&&e.SignupForm(...n)),["prevent"])),class:"signup"},[(0,s.wy)((0,s._)("input",{"onUpdate:modelValue":n[0]||(n[0]=n=>e.name=n),class:"login-form__input",type:"text",name:"name",required:"",placeholder:"이름"},null,512),[[a.nr,e.name]]),(0,s.wy)((0,s._)("input",{"onUpdate:modelValue":n[1]||(n[1]=n=>e.email=n),class:"login-form__input",type:"text",name:"email",required:"",placeholder:"이메일"},null,512),[[a.nr,e.email]]),(0,s._)("button",{class:"login-form__btn_right",onClick:n[2]||(n[2]=n=>m.existEmail(e.email))},"이메일 중복 검사"),(0,s.wy)((0,s._)("input",{"onUpdate:modelValue":n[3]||(n[3]=n=>e.passwd=n),class:"login-form__input",type:"password",name:"password",id:"password",required:"",placeholder:"비밀번호",minlength:"6"},null,512),[[a.nr,e.passwd]]),i,(0,s.wy)((0,s._)("input",{"onUpdate:modelValue":n[4]||(n[4]=n=>e.phonenum=n),class:"login-form__input",type:"number",name:"phonenum",required:"",placeholder:"휴대폰번호"},null,512),[[a.nr,e.phonenum]]),(0,s._)("button",{class:"login-form__btn_right",onClick:n[5]||(n[5]=n=>m.kind({name:e.name,email:e.email,passwd:e.passwd,phonenum:e.phonenum}))},"다음")],32)])])}var u={name:"SignupForm",data(){return{f_name:null,f_email:null,f_passwd:null,f_phonenum:null}},methods:{existEmail(e){console.log(e),this.$store.dispatch("existEmail",e)},kind(e){this.$store.commit("FARM_INFO",e),console.log(this.$store.state.kindOfFarm),console.log(this.$store.state.user),"1"==this.$store.state.kindOfFarm?this.$router.push({name:"farm_user_info"}):this.$router.push({name:"farm_biz_info"})}}},m=l(89);const p=(0,m.Z)(u,[["render",r]]);var d=p}}]);
//# sourceMappingURL=164.4664d465.js.map