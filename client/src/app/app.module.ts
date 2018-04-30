import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {MainService} from './service/MainService';
import {AuthenticationService} from './service/authentication.service';
import {AppRoutingModule, routingComponents} from './app-routing-module';
import {HeaderComponent} from './components/header/header.component';
import {LoginComponent} from './components/login/login.component';
import {AdminComponent} from './components/admin/admin.component';
import {ToursComponent} from './components/tours/tours.component';
import {DetailsComponent} from './components/details/details.component';
import {HttpModule} from '@angular/http';
import {RolePipe} from './pipes/role.pipe';
import {RegistrationComponent} from './components/registration/registration.component';
import {AdminGuard} from './components/guards/auth/admin.guard';
import {PagerService} from './service/pager.service';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    HeaderComponent,
    LoginComponent,
    AdminComponent,
    ToursComponent,
    DetailsComponent,
    RolePipe,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    HttpModule,
  ],
  providers: [MainService, AuthenticationService, AdminGuard, PagerService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
