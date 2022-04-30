import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Trail } from '../contracts/models';
import { CreateTrailRequest } from '../contracts/requests';

@Injectable({
  providedIn: 'root',
})
export class TrailService {
  public trails: BehaviorSubject<Trail[]> = new BehaviorSubject<Trail[]>([]);

  constructor(private httpClient: HttpClient) {}

  public getTrails(): void {
    this.trails.next([]);

    this.httpClient
      .get<Trail[]>('trails')
      .subscribe((trails) => this.trails.next(trails));
  }

  public getMyTrails(userId: number): void {
    this.trails.next([]);

    this.httpClient
      .get<Trail[]>(`trails/${userId}`)
      .subscribe((trails) => this.trails.next(trails));
  }

  public postTrail(userId: number, request: CreateTrailRequest): void {
    this.httpClient
      .post<Trail>(`http://localhost:7070/trail/${userId}`, request)
      .subscribe((trail) => {
        this.trails.next(this.trails.value.splice(0, 0, trail));
      });
  }

  public updateTrail(
    userId: number,
    trailId: number,
    request: CreateTrailRequest
  ): void {
    this.httpClient
      .put<Trail>(`http://localhost:7070/trail/${userId}/${trailId}`, request)
      .subscribe((trail) => {
        this.trails.next(
          this.trails.value.map((x) => (x.id === trailId ? trail : x))
        );
      });
  }

  public deleteTrail(userId: number, trailId: number): void {
    this.httpClient
      .delete<Trail>(`http://localhost:7070/trail/${userId}/${trailId}`)
      .subscribe(() => {
        this.trails.next(this.trails.value.filter((x) => x.id !== trailId));
      });
  }
}
