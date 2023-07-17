import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';

import { IssuePolicyComponent } from './issue-policy/issue-policy.component';

import { CreatePolicyComponent } from './create-policy/create-policy.component';
import { ViewPolicyComponent } from './view-policy/view-policy.component';
import { ConsumerDetailsComponent } from './consumer-details/consumer-details.component';
import { PolicyComponent } from './policy/policy.component';
import { ConsumerComponent } from './consumer/consumer.component';
import { AddPropertyComponent } from './add-property/add-property.component';
import { UpdateConsumerComponent } from './update-consumer/update-consumer.component';
import { ViewConsumerComponent } from './view-consumer/view-consumer.component';
import { BusinessComponent } from './business/business.component';
import { QuotesComponent } from './quotes/quotes.component';
import { UpdateBusinessComponent } from './update-business/update-business.component';
import { ViewBusinessComponent } from './view-business/view-business.component';
import { ViewPropertyComponent } from './view-property/view-property.component';
import { ViewDetailPolicyComponent } from './view-detail-policy/view-detail-policy.component';
import { ViewBusinessDialogComponent } from './view-business-dialog/view-business-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,

    IssuePolicyComponent,

    CreatePolicyComponent,
    ViewPolicyComponent,
    ConsumerDetailsComponent,
    PolicyComponent,
    ConsumerComponent,
    AddPropertyComponent,
    UpdateConsumerComponent,
    ViewConsumerComponent,
    BusinessComponent,
    QuotesComponent,
    UpdateBusinessComponent,
    ViewBusinessComponent,
    ViewPropertyComponent,
    ViewDetailPolicyComponent,
    ViewBusinessDialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    MatSidenavModule,
    MatToolbarModule,
    MatDialogModule,
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent],
})
export class AppModule {}
