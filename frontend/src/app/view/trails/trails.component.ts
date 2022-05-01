import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { distinctUntilChanged } from 'rxjs';
import { Trail } from 'src/app/contracts/models';
import { TrailService } from 'src/app/service/trail.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-trails',
  templateUrl: './trails.component.html',
  styleUrls: ['./trails.component.css'],
})
export class TrailsComponent implements OnInit {
  public trails: Trail[] = [];
  public isMyRoutes: boolean = false;

  constructor(
    private trailService: TrailService,
    private userService: UserService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.queryParams
      .pipe(distinctUntilChanged((q) => q['my']))
      .subscribe((q) => {
        this.isMyRoutes = !!q['my'];

        if (this.isMyRoutes) {
          this.trailService.getMyTrails(this.userService.logedInUser?.id ?? 0);
        } else {
          this.trailService.getTrails();
        }
      });

    this.trailService.trails.subscribe((t) => (this.trails = t));
  }
}
