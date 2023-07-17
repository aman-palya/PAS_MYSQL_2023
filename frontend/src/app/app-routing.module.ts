import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPropertyComponent } from './add-property/add-property.component';
import { BusinessComponent } from './business/business.component';
import { ConsumerDetailsComponent } from './consumer-details/consumer-details.component';
import { ConsumerComponent } from './consumer/consumer.component';

import { CreatePolicyComponent } from './create-policy/create-policy.component';
import { HomeComponent } from './home/home.component';
import { IssuePolicyComponent } from './issue-policy/issue-policy.component';
import { LoginComponent } from './login/login.component';
import { PolicyComponent } from './policy/policy.component';
import { QuotesComponent } from './quotes/quotes.component';

import { SignupComponent } from './signup/signup.component';
import { UpdateBusinessComponent } from './update-business/update-business.component';
import { UpdateConsumerComponent } from './update-consumer/update-consumer.component';
import { ViewBusinessComponent } from './view-business/view-business.component';
import { ViewConsumerComponent } from './view-consumer/view-consumer.component';
import { ViewDetailPolicyComponent } from './view-detail-policy/view-detail-policy.component';

import { ViewPolicyComponent } from './view-policy/view-policy.component';
import { ViewPropertyComponent } from './view-property/view-property.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'home', component: HomeComponent },
  { path: 'addProperty', component: AddPropertyComponent },
  { path: 'consumer', component: ConsumerComponent },
  { path: 'policy', component: PolicyComponent },
  { path: 'issue-policy', component: IssuePolicyComponent },
  { path: 'createPolicy', component: CreatePolicyComponent },
  { path: 'viewPolicy', component: ViewPolicyComponent },
  { path: 'consumerDetails', component: ConsumerDetailsComponent },
  { path: 'updateConsumer', component: UpdateConsumerComponent },
  { path: 'viewConsumer', component: ViewConsumerComponent },
  { path: 'business', component: BusinessComponent },
  { path: 'quotes', component: QuotesComponent },
  { path: 'updateBusiness', component: UpdateBusinessComponent },
  { path: 'viewBusiness', component: ViewBusinessComponent },
  { path: 'viewProperty', component: ViewPropertyComponent },
  { path: 'viewDetailPolicy', component: ViewDetailPolicyComponent },
  // {path:'viewDetailPolicy/:id',component:ViewDetailPolicyComponent}

  // {path:'policy/:id/:cid',component:PolicyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
